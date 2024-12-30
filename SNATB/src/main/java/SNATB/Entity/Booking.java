package SNATB.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Booking")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Bookingid")
	private Long bookingId;

	@Column(name = "Createddate")
	private LocalDateTime createdDate;

	@Column(name = "Status", nullable = false)
	private Boolean status=true;

	@Column(name = "Note", length = 255)
	private String note;
	
	@Column(name = "Totalamount")
	private Double totalAmount;

	@Column(name = "Paymentmethod", length = 50)
	private String paymentMethod;

	@Column(name = "Transactionid", length = 255)
	private String VnPayTransactionId;
	
	@ManyToOne
	@JoinColumn(name = "Username", referencedColumnName = "Username")
	private Account userName;

	@ManyToOne
	@JoinColumn(name = "Scheduleid", referencedColumnName = "Scheduleid")
	private Schedule schedule;

//	@OneToOne(cascade = CascadeType.ALL) // Cascade để tạo hoặc xóa Invoice cùng Booking
//	@JoinColumn(name = "Invoiceid", referencedColumnName = "Invoiceid") // Liên kết qua khóa ngoại
//	private Invoice invoice;

	@ManyToOne
	@JoinColumn(name = "Usernamead", referencedColumnName = "Usernamead" , nullable = true)
	private Admin admin;
}
