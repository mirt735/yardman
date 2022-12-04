package solvo.yardman.models.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import solvo.yardman.models.Car;
import solvo.yardman.models.dto.request.car.CarRequestDTO;
import solvo.yardman.models.dto.response.car.CarResponseDTO;

@Mapper(componentModel = "spring")
public interface CarMapper {

    CarResponseDTO toResponseDTO(Car car);

    Car toModel(CarRequestDTO carRequestDTO);

}
