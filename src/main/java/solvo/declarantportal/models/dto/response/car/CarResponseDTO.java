package solvo.declarantportal.models.dto.response.car;

import lombok.Getter;
import lombok.Setter;
import solvo.declarantportal.models.dto.response.cartype.CarTypeResponseDTO;

@Getter
@Setter
public class CarResponseDTO {

    private Long id;

    private String regNumber;

    private CarTypeResponseDTO carType;

    private Long carrierId;

}
