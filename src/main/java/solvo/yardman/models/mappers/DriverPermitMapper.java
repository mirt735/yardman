package solvo.yardman.models.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import solvo.yardman.models.DriverPermit;
import solvo.yardman.models.dto.request.driverPermit.DriverPermitRequestDTO;
import solvo.yardman.models.dto.response.driverPermit.DriverPermitListDTO;
import solvo.yardman.models.dto.response.driverPermit.DriverPermitResponseDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DriverPermitMapper {

    DriverPermitMapper INSTANCE = Mappers.getMapper(DriverPermitMapper.class);

    DriverPermitRequestDTO driverPermitToDriverPermitRequestDTO(DriverPermit driverPermit);
    DriverPermitResponseDTO driverPermitToDriverPermitResponseDTO(DriverPermit driverPermit);

    DriverPermit driverPermitRequestDTOToDriverPermit(DriverPermitRequestDTO driverPermitRequestDTO);
    DriverPermit driverPermitResponseDTOToDriverPermit(DriverPermitResponseDTO driverPermitRequestDTO);

    @Mapping(target = "", source = "value.driverPermitList")
    List<DriverPermit> map(DriverPermitListDTO value);
}
