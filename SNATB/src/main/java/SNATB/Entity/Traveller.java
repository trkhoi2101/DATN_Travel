package SNATB.Entity;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "Travellers")
public class Traveller {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Travellerid")
	private Long travellerId;

	@Column(name = "Fullname", length = 255)
	private String fullName;

	@Column(name = "Phone", length = 10)
	private String phone;

	@Column(name = "Birthday")
	@Temporal(TemporalType.DATE)
	private Date birthday;

	@ManyToOne
	@JoinColumn(name = "Bookingid", referencedColumnName = "Bookingid")
	private Booking booking;
}
