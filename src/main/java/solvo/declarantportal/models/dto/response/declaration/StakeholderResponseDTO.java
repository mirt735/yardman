package solvo.declarantportal.models.dto.response.declaration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StakeholderResponseDTO {

    private Long id;

    private String fullName;

    private String shortName;

    private String phone;

    private String contactFace;

    private String email;

    private String type;


}
