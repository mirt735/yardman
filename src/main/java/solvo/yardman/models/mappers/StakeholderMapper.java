package solvo.yardman.models.mappers;

import org.mapstruct.Mapper;
import solvo.yardman.models.dto.request.stakeholder.StakeholderRequestDTO;
import solvo.yardman.models.dto.response.stakeholder.StakeholderResponseDTO;
import solvo.yardman.models.entities.Stakeholder;

@Mapper(componentModel = "spring")
public interface StakeholderMapper {

    StakeholderResponseDTO toResponseDTO(Stakeholder driver);

    Stakeholder toModel(StakeholderRequestDTO driverRequestDTO);

}
