package SNATB.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "Accounts")
public class Account {

	@Id
	@Column(name = "Username", length = 100)
//    @NotNull(message = "User ID cannot be null")
//    @Size(min = 3, max = 50, message = "User ID must be between 3 and 50 characters")
	private String userName;

	@Column(name = "Createddate")
//    @NotNull(message = "Created date cannot be null")
	private LocalDateTime createdDate;

	@Column(name = "Updatedate")
	private LocalDateTime updateDate;

	@Column(name = "Status", nullable = false, columnDefinition = "BIT DEFAULT 1")
//    @NotNull(message = "Activation status is required")
	private Boolean status;

	@Column(name = "Address", columnDefinition = "NVARCHAR(MAX)")
//    @Size(max = 255, message = "Address cannot be longer than 255 characters")
	private String address;

	@Column(name = "Avatar", columnDefinition = "NVARCHAR(MAX)")
//    @Size(max = 255, message = "Avatar URL cannot be longer than 255 characters")
	private String avatar;

	@Column(name = "Birthday")
	@Temporal(TemporalType.DATE)
//    @Past(message = "Birthday must be a past date")
	private Date birthday;

	@Column(name = "Password", length = 255)
//    @NotNull(message = "Password cannot be null")
//    @Size(min = 6, max = 255, message = "Password must be between 8 and 255 characters")
	private String password;

	@Column(name = "Email", length = 255)
//    @Email(message = "Email should be valid")
//    @Size(max = 255, message = "Email cannot be longer than 255 characters")
	private String email;

	@Column(name = "Firstname", length = 255)
//    @NotNull(message = "Full name cannot be null")
//    @Size(min = 3, max = 255, message = "Full name must be between 3 and 255 characters")
	private String firstname;

	@Column(name = "Lastname", length = 255)
//    @NotNull(message = "Full name cannot be null")
//    @Size(min = 3, max = 255, message = "Full name must be between 3 and 255 characters")
	private String lastname;

	@Column(name = "Phone", length = 10)
//    @Pattern(regexp = "^\\+?[0-9]*$", message = "Phone number must contain only digits and optional '+' sign")
	private String phone;

	@Column(name = "Gender", nullable = false, columnDefinition = "BIT DEFAULT 1")
//    @NotNull(message = "Gender cannot be null")
	private Boolean gender;

	@Column(name = "Vip", nullable = false, columnDefinition = "BIT DEFAULT 0")
	private Boolean vip;
}
