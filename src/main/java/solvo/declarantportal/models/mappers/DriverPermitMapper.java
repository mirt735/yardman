package solvo.declarantportal.models.mappers;

import org.mapstruct.Mapper;
import solvo.declarantportal.models.dto.request.driverPermit.DriverPermitRequestDTO;
import solvo.declarantportal.models.dto.response.driverPermit.DriverPermitResponseDTO;
import solvo.declarantportal.models.entities.DriverPermit;

@Mapper(componentModel = "spring")
public interface DriverPermitMapper {

    DriverPermitResponseDTO toResponseDTO(DriverPermit driverPermit);

    DriverPermit toModel(DriverPermitRequestDTO driverPermitRequestDTO);

}
