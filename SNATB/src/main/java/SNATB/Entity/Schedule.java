package SNATB.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Schedules")
public class Schedule {

	@Id
	@Column(name = "Scheduleid")
	private String scheduleId;

	@Column(name = "Createddate")
	private LocalDateTime createdDate;

	@Column(name = "Updatedate")
	private LocalDateTime updateDate;

	@Column(name = "Startdate")
	private LocalDateTime startDate;

	@Column(name = "EndDate")
	private LocalDateTime endDate;

	@Column(name = "Childrenprice")
	private Double childrenPrice; // Giá vé trẻ em

	@Column(name = "Adultprice")
	private Double adultPrice; // Giá vé người lớn

	@Column(name = "Vehicle", length = 100)
	private String vehicle;

	@Column(name = "Itinerary", columnDefinition = "NVARCHAR(MAX)")
	private String itinerary;

	@Column(name = "Quantity")
	private Long quantity;

	@ManyToOne
	@JoinColumn(name = "Tourid", referencedColumnName = "Tourid", nullable = false)
	private Tour tour; // Quan hệ nhiều đến 1 với bảng Tour_Detail
	
	@ManyToOne
	@JoinColumn(name = "Usernamead", referencedColumnName = "Usernamead")
	private Admin admin;
	
	public Schedule(String scheduleId) {
	    this.scheduleId = scheduleId;
	}

	
}
