package solvo.yardman.models.mappers;

import org.mapstruct.Mapper;
import solvo.yardman.models.dto.request.car.CarRequestDTO;
import solvo.yardman.models.dto.response.car.CarResponseDTO;
import solvo.yardman.models.entities.Car;

@Mapper(componentModel = "spring")
public interface CarMapper {

    CarResponseDTO toResponseDTO(Car car);

    Car toModel(CarRequestDTO carRequestDTO);

}
