package SNATB.Entity;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "Admin")
public class Admin {
	
	@Id
	@Column(name = "Usernamead", length = 255)
	private String userNameAd;
	
	@Column(name = "Createddate")
	private LocalDateTime createdDate;

	@Column(name = "Updatedate")
	private LocalDateTime updateDate;
	
	@Column(name = "Status", nullable = false, columnDefinition = "BIT DEFAULT 1")
	private Boolean status;
	
	@Column(name = "Gender")
    private Boolean gender;
	
	@Column(name = "Avatar", length = 255)
	private String avatar;
	
	@Column(name = "Birthday")
	@Temporal(TemporalType.DATE)
	private Date birthday;
	
	@Column(name = "Password", length = 255)
	private String password;
	
	@Column(name = "Email", length = 255)
	private String email;
	
	@Column(name = "Firstname", length = 100)
	private String firstName;
	
	@Column(name = "Lastname", length = 100)
	private String lastName;
	
	@Column(name = "Phone", length = 15)
	private String phone;
	
}	
