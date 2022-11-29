package solvo.yardman.models.dto.response.driverPermit;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class DriverPermitListDTO {

    private final List<DriverPermitResponseDTO> driverPermitList;

    private final int size;
}
