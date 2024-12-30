package SNATB.Entity;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Tours")
public class Tour {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Tourid")
	private Long tourId;

	@Column(name = "Createddate")
	private LocalDateTime createdDate;

	@Column(name = "Updatedate")
	private LocalDateTime updateDate;

	@Column(name = "Title", length = 255)
	private String title;

	@Column(name = "Image", columnDefinition = "NVARCHAR(MAX)")
	private String image;

	@Column(name = "Status", nullable = false, columnDefinition = "BIT DEFAULT 1")
	private Boolean status;

	@Column(name = "Description", length = 255)
	private String description;

	@Column(name = "Destination", length = 100)
	private String destination;

	@Column(name = "Departure", length = 100)
	private String departure;

	@Column(name = "Policy", length = 255)
	private String policy;

	@ManyToOne
	@JoinColumn(name = "Usernamead", referencedColumnName = "Usernamead")
	private Admin admin;
}
