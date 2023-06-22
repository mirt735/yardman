package solvo.declarantportal.models.mappers;

import org.mapstruct.Mapper;
import solvo.declarantportal.models.dto.request.cartype.CarTypeRequestDTO;
import solvo.declarantportal.models.dto.response.cartype.CarTypeResponseDTO;
import solvo.declarantportal.models.entities.CarType;

@Mapper(componentModel = "spring")
public interface CarTypeMapper {

    CarTypeResponseDTO toResponseDTO(CarType carType);

    CarType toModel(CarTypeRequestDTO carTypeRequestDTO);

}
