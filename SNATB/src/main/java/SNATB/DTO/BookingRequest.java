package SNATB.DTO;

import java.util.List;

import lombok.Data;

@Data
public class BookingRequest {
    private String scheduleId;
    private String note;
    private String paymentMethod;
    private Double totalAmount;
    private String VnPayTransactionId;
    private List<TravellerRequest> travellers;
}
