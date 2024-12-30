package SNATB.DTO;

import java.sql.Date;

import lombok.Data;

@Data
public class TravellerRequest {
    private String fullName;
    private String phone;
    private Date birthday;
}
