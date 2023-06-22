package solvo.declarantportal.models.dto.response.driver;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class DriverListDTO {

    private final List<DriverResponseDTO> driverList;

    private final int size;

}
