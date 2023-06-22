package solvo.declarantportal.models.dto.response.car;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class CarListDTO {

    private final List<CarResponseDTO> carList;

    private final int size;

}
