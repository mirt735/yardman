package solvo.yardman.models.dto.request.stakeholder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StakeholderRequestDTO {

    private String fullName;

    private String shortName;

    private String phone;

    private String contactFace;

    private String email;

    private String type;

}
