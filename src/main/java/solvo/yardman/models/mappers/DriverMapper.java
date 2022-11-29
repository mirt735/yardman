package solvo.yardman.models.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import solvo.yardman.models.Driver;
import solvo.yardman.models.dto.request.driver.DriverRequestDTO;
import solvo.yardman.models.dto.response.driver.DriverListDTO;
import solvo.yardman.models.dto.response.driver.DriverResponseDTO;
import solvo.yardman.models.dto.response.driverPermit.DriverPermitListDTO;
import solvo.yardman.models.dto.response.driverPermit.DriverPermitResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface DriverMapper {

    DriverMapper INSTANCE = Mappers.getMapper(DriverMapper.class);
    DriverPermitMapper DRIVER_PERMIT_MAPPER = Mappers.getMapper(DriverPermitMapper.class);

    DriverRequestDTO driverToDriverRequestDTO(Driver driver);
    @Mapping(target = "permits", source = "driver", qualifiedByName = "extractPermits")
    DriverResponseDTO driverToDriverResponseDTO(Driver driver);

    Driver driverRequestDTOToDriver(DriverRequestDTO driverRequestDTO);
    Driver driverResponseDTOToDriver(DriverResponseDTO driverRequestDTO);

    @Named("extractPermits")
    default DriverPermitListDTO extractPermits(final Driver driver)
    {
        List<DriverPermitResponseDTO> permitResponseDTOS = driver.getPermits().stream().map(DRIVER_PERMIT_MAPPER::driverPermitToDriverPermitResponseDTO).collect(Collectors.toList());
        return new DriverPermitListDTO(permitResponseDTOS, permitResponseDTOS.size());
    }

}
