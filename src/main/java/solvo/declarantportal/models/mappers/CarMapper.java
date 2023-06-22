package solvo.declarantportal.models.mappers;

import org.mapstruct.Mapper;
import solvo.declarantportal.models.dto.request.car.CarRequestDTO;
import solvo.declarantportal.models.dto.response.car.CarResponseDTO;
import solvo.declarantportal.models.entities.Car;

@Mapper(componentModel = "spring")
public interface CarMapper {

    CarResponseDTO toResponseDTO(Car car);

    Car toModel(CarRequestDTO carRequestDTO);

}
