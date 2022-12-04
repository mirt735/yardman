package solvo.yardman.models.dto.request.car;

import lombok.Getter;
import lombok.Setter;
import solvo.yardman.models.dto.request.cartype.CarTypeRequestDTO;

@Getter
@Setter
public class CarRequestDTO {

    private String regNumber;

    private Long carTypeId;

    private Long carrierId;

    private Long lastDriverId;

}
