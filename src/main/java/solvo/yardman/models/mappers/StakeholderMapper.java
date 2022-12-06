package solvo.yardman.models.mappers;

import org.mapstruct.Mapper;
import solvo.yardman.models.Stakeholder;
import solvo.yardman.models.dto.request.stakeholder.StakeholderRequestDTO;
import solvo.yardman.models.dto.response.stakeholder.StakeholderResponseDTO;

@Mapper(componentModel = "spring")
public interface StakeholderMapper {

    StakeholderResponseDTO toResponseDTO(Stakeholder driver);

    Stakeholder toModel(StakeholderRequestDTO driverRequestDTO);

}
