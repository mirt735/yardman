package solvo.yardman.models.mappers;

import org.mapstruct.Mapper;
import solvo.yardman.models.CarType;
import solvo.yardman.models.dto.request.cartype.CarTypeRequestDTO;
import solvo.yardman.models.dto.response.cartype.CarTypeResponseDTO;

@Mapper(componentModel = "spring")
public interface CarTypeMapper {

    CarTypeResponseDTO toResponseDTO(CarType carType);

    CarType toModel(CarTypeRequestDTO carTypeRequestDTO);

}
