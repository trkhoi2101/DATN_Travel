//package SNATB.Entity;
//
//import java.time.LocalDateTime;
//import java.util.Date;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToOne;
//import jakarta.persistence.Table;
//import jakarta.persistence.Temporal;
//import jakarta.persistence.TemporalType;
//import lombok.Data;
//
//@Data
//@Entity
//@Table(name = "Invoices")
//public class Invoice {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "Invoiceid")
//	private Long invoiceId;
//
//	@Column(name = "Createddate")
//	private LocalDateTime createdDate;
//
//	@Column(name = "Totalamount")
//	private Double totalAmount;
//
//	@Column(name = "Status", nullable = false, columnDefinition = "BIT DEFAULT 1")
//	private Boolean status;
//
//	@Column(name = "Note", columnDefinition = "NVARCHAR(MAX)")
//	private String note;
//
//	@Column(name = "Paymentmethod", length = 50)
//	private String paymentMethod;
//
//	@Column(name = "Momotransactionid", length = 255)
//	private String momoTransactionId;
//
//	@Column(name = "Vnpaytransactionid", length = 255)
//	private String vnPayTransactionId;
//
//	/*
//	 * @OneToOne(mappedBy = "invoice") // Liên kết ngược với Booking private Booking
//	 * booking; // Tham chiếu đến Booking
//	 */}
