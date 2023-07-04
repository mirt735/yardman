package solvo.yardman.models.mappers;

import org.mapstruct.Mapper;
import solvo.yardman.models.dto.request.cartype.CarTypeRequestDTO;
import solvo.yardman.models.dto.response.cartype.CarTypeResponseDTO;
import solvo.yardman.models.entities.CarType;

@Mapper(componentModel = "spring")
public interface CarTypeMapper {

    CarTypeResponseDTO toResponseDTO(CarType carType);

    CarType toModel(CarTypeRequestDTO carTypeRequestDTO);

}
