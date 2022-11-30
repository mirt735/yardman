package solvo.yardman.models.mappers;

import org.mapstruct.Mapper;
import solvo.yardman.models.DriverPermit;
import solvo.yardman.models.dto.request.driverPermit.DriverPermitRequestDTO;
import solvo.yardman.models.dto.response.driverPermit.DriverPermitResponseDTO;

@Mapper(componentModel = "spring")
public interface DriverPermitMapper {

    DriverPermitResponseDTO toResponseDTO(DriverPermit driverPermit);

    DriverPermit toModel(DriverPermitRequestDTO driverPermitRequestDTO);

}
