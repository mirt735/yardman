package solvo.yardman.models.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import solvo.yardman.models.Driver;
import solvo.yardman.models.dto.request.driver.DriverRequestDTO;
import solvo.yardman.models.dto.response.driver.DriverResponseDTO;

@Mapper(componentModel = "spring")
public interface DriverMapper {

    @Mapping(target = "permits", ignore = true)
    DriverResponseDTO toResponseDTO(Driver driver);

    Driver toModel(DriverRequestDTO driverRequestDTO);

}
