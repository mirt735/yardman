package solvo.declarantportal.models.dto.request.driver;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DriverRequestDTO {

    private String fullName;

    private String phone;

    private String passport;

    private String passportIssuedBy;

}
