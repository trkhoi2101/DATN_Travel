package SNATB.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SNATB.DAO.BookingDAO;
import SNATB.DAO.DAO;
//import SNATB.DAO.InvoiceDAO;
import SNATB.DAO.TravellerDAO;
import SNATB.DTO.BookingRequest;
import SNATB.DTO.TravellerRequest;
import SNATB.Entity.Booking;
//import SNATB.Entity.Invoice;
import SNATB.Entity.Schedule;
import SNATB.Entity.Traveller;


@Service
public class BookingService_2{

	@Autowired
	private BookingDAO bookingDao;
	
	@Autowired
	private TravellerDAO travellerRepository;

//	@Autowired
//	private InvoiceDAO invoiceRepository;
	
	public void createBooking(BookingRequest request) {
        // 1. Lưu Booking
        Booking booking = new Booking();
        booking.setCreatedDate(LocalDateTime.now());
        booking.setStatus(true);
        booking.setNote(request.getNote());
        booking.setSchedule(new Schedule(request.getScheduleId()));
        booking.setPaymentMethod(request.getPaymentMethod());
        booking.setTotalAmount(request.getTotalAmount());
        booking.setVnPayTransactionId(request.getVnPayTransactionId());
        bookingDao.save(booking);
        System.out.println("Booking Object before saving: " + booking);  // Log đối tượng Booking

        // 3. Lưu danh sách Traveller
        for (TravellerRequest travellerRequest : request.getTravellers()) {
            Traveller traveller = new Traveller();
            traveller.setFullName(travellerRequest.getFullName());
            traveller.setPhone(travellerRequest.getPhone());
            traveller.setBirthday(travellerRequest.getBirthday());
            traveller.setBooking(booking);
            travellerRepository.save(traveller);
        }
    }

}
