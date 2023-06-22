package solvo.declarantportal.models.mappers;

import org.mapstruct.Mapper;
import solvo.declarantportal.models.dto.request.declaration.StakeholderRequestDTO;
import solvo.declarantportal.models.dto.response.declaration.StakeholderResponseDTO;
import solvo.declarantportal.models.entities.Stakeholder;

@Mapper(componentModel = "spring")
public interface StakeholderMapper {

    StakeholderResponseDTO toResponseDTO(Stakeholder driver);

    Stakeholder toModel(StakeholderRequestDTO driverRequestDTO);

}
