package solvo.declarantportal.models.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import solvo.declarantportal.models.dto.request.driver.DriverRequestDTO;
import solvo.declarantportal.models.dto.response.driver.DriverResponseDTO;
import solvo.declarantportal.models.entities.Driver;

@Mapper(componentModel = "spring")
public interface DriverMapper {

    @Mapping(target = "permits", ignore = true)
    DriverResponseDTO toResponseDTO(Driver driver);

    Driver toModel(DriverRequestDTO driverRequestDTO);

}
