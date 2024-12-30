package SNATB.REST;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.eclipse.angus.mail.handlers.message_rfc822;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import SNATB.Config.Config;
import SNATB.DAO.BookingDAO;
import SNATB.DAO.TravellerDAO;
import SNATB.DTO.BookingRequest;
import SNATB.DTO.PaymentDTO;
import SNATB.DTO.TravellerRequest;
import SNATB.Entity.Booking;
import SNATB.Entity.Schedule;
import SNATB.Entity.Traveller;
import SNATB.Service.BookingService_2;
import jakarta.mail.Message;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin("*")
@RestController
@RequestMapping("/user/REST")
public class VNPAYPaymentREST {
	
//	@Autowired
//    private InvoiceDAO invoiceDAO;
	@Autowired
    private BookingDAO bookingDAO;
	@Autowired
    private TravellerDAO travellerDAO;
	
    private static final Logger logger = LoggerFactory.getLogger(VNPAYPaymentREST.class);

    @GetMapping("/payment/vnpay")
    public ResponseEntity<Map<String, String>> getPay(@RequestParam("amount") long amount) throws UnsupportedEncodingException {

        if (amount <= 0) {
            throw new IllegalArgumentException("Số tiền thanh toán phải lớn hơn 0");
        }

        
        
        String vnp_Version = "2.1.0";
        String vnp_Command = "pay";
        String orderType = "other";
        String bankCode = "NCB";
        String vnp_TxnRef = Config.getRandomNumber(8);
        String vnp_IpAddr = "127.0.0.1";

        String vnp_TmnCode = Config.vnp_TmnCode;

        Map<String, String> vnp_Params = new HashMap<>();
        vnp_Params.put("vnp_Version", vnp_Version);
        vnp_Params.put("vnp_Command", vnp_Command);
        vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
        vnp_Params.put("vnp_Amount", String.valueOf(amount * 100)); // Đơn vị VNPay là x100
        vnp_Params.put("vnp_CurrCode", "VND");
        vnp_Params.put("vnp_BankCode", bankCode);
        vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
        vnp_Params.put("vnp_OrderInfo", "Thanh toán đơn hàng: " + vnp_TxnRef);
        vnp_Params.put("vnp_OrderType", orderType);
        vnp_Params.put("vnp_Locale", "vn");
        vnp_Params.put("vnp_ReturnUrl", Config.vnp_ReturnUrl);
        vnp_Params.put("vnp_IpAddr", vnp_IpAddr);

        Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String vnp_CreateDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_CreateDate", vnp_CreateDate);

        cld.add(Calendar.MINUTE, 15); // Hết hạn sau 15 phút
        String vnp_ExpireDate = formatter.format(cld.getTime());
        vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

        // Sắp xếp và mã hóa tham số
        List<String> fieldNames = vnp_Params.keySet().stream().sorted().collect(Collectors.toList());
        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();

        for (String fieldName : fieldNames) {
            String fieldValue = vnp_Params.get(fieldName);
            if (fieldValue != null && !fieldValue.isEmpty()) {
                hashData.append(fieldName).append('=').append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString())).append('&');
                query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString())).append('=').append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString())).append('&');
            }
        }

        String queryUrl = query.substring(0, query.length() - 1); // Xóa ký tự `&` cuối cùng
        String vnp_SecureHash = Config.hmacSHA512(Config.secretKey, hashData.substring(0, hashData.length() - 1));
        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;

        String paymentUrl = Config.vnp_PayUrl + "?" + queryUrl;

        logger.info("VNPay Payment URL: {}", paymentUrl);

        Map<String, String> response = new HashMap<>();
        response.put("paymentUrl", paymentUrl);
        return ResponseEntity.ok(response);
    }
    
//    @PostMapping("/vnpay-callback")
//    public ResponseEntity<String> vnpayCallback(HttpServletRequest request, @RequestBody BookingRequest brequest) {
//        try {
//            String vnp_ResponseCode = request.getParameter("vnp_ResponseCode");
//            String vnp_TransactionNo = request.getParameter("vnp_TransactionNo");
//            String vnp_TxnRef = request.getParameter("vnp_TxnRef");
//            double vnp_Amount = Double.parseDouble(request.getParameter("vnp_Amount"));
//            String vnp_SecureHash = request.getParameter("vnp_SecureHash");
//
//            String hashData = getHashData(request);
//            String secureHash = Config.hmacSHA512(Config.secretKey, hashData);
//            if (!secureHash.equals(vnp_SecureHash)) {
//                logger.error("Mã bảo mật không hợp lệ.");
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Mã bảo mật không hợp lệ.");
//            }
//
//            if (!"00".equals(vnp_ResponseCode)) {
//                logger.error("Thanh toán thất bại, mã phản hồi: {}", vnp_ResponseCode);
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Thanh toán thất bại!");
//            }
//
//            Booking booking = new Booking();
//            booking.setCreatedDate(LocalDateTime.now());
//            booking.setStatus(true);
//            booking.setNote(brequest.getNote());
//            booking.setSchedule(new Schedule(brequest.getScheduleId()));
//            bookingDAO.save(booking);
//
//            Invoice invoice = new Invoice();
//            invoice.setCreatedDate(LocalDateTime.now());
//            invoice.setTotalAmount(vnp_Amount);
//            invoice.setPaymentMethod(brequest.getPaymentMethod());
//            invoice.setVnPayTransactionId(vnp_TransactionNo);
//            invoice.setStatus(true);
//            invoiceDAO.save(invoice);
//
//            booking.setInvoice(invoice);
//            bookingDAO.save(booking);
//
//            for (TravellerRequest travellerRequest : brequest.getTravellers()) {
//                Traveller traveller = new Traveller();
//                traveller.setFullName(travellerRequest.getFullName());
//                traveller.setPhone(travellerRequest.getPhone());
//                traveller.setBirthday(travellerRequest.getBirthday());
//                traveller.setBooking(booking);
//                travellerDAO.save(traveller);
//            }
//
//            return ResponseEntity.ok("Thanh toán và lưu thông tin thành công!");
//
//        } catch (Exception e) {
//            logger.error("Lỗi xử lý callback: {}", e.getMessage());
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Có lỗi xảy ra.");
//        }
//    }
//
//    private String getHashData(HttpServletRequest request) throws UnsupportedEncodingException {
//        return request.getParameterMap().entrySet().stream()
//                .filter(e -> !"vnp_SecureHash".equals(e.getKey()))
//                .sorted(Map.Entry.comparingByKey())
//                .map(e -> e.getKey() + "=" + URLEncoder.encode(e.getValue()[0], StandardCharsets.US_ASCII))
//                .collect(Collectors.joining("&"));
//    }
}
