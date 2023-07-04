package solvo.yardman.models.dto.response.cartype;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class CarTypeListDTO {

    private final List<CarTypeResponseDTO> carTypeList;

    private final int size;

}
