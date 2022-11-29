package solvo.yardman.models.dto.response.driver;

import lombok.Getter;
import lombok.Setter;
import solvo.yardman.models.dto.response.driverPermit.DriverPermitListDTO;

@Getter
@Setter
public class DriverResponseDTO {

    private Long id;

    private String fullName;

    private String phone;

    private String passport;

    private String passportIssuedBy;

    private DriverPermitListDTO permits;

}
