package solvo.yardman.models.mappers;

import org.mapstruct.Mapper;
import solvo.yardman.models.dto.request.aSample.ASampleRequestDTO;
import solvo.yardman.models.dto.response.aSample.ASampleResponseDTO;
import solvo.yardman.models.entities.ASample;

@Mapper(componentModel = "spring")
public interface ASampleMapper
{
    ASampleResponseDTO toResponseDTO(ASample aSample);

    ASample toModel(ASampleRequestDTO aSampleRequestDTO);
}
