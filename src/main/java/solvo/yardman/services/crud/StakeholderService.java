package solvo.yardman.services.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import solvo.yardman.models.dto.request.stakeholder.StakeholderRequestDTO;
import solvo.yardman.models.dto.response.stakeholder.StakeholderListDTO;
import solvo.yardman.models.dto.response.stakeholder.StakeholderResponseDTO;
import solvo.yardman.models.entities.Stakeholder;
import solvo.yardman.models.mappers.StakeholderMapper;
import solvo.yardman.repositories.StakeholderRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StakeholderService {

    private final StakeholderRepository stakeholderRepository;

    private final StakeholderMapper stakeholderMapper;

    public StakeholderListDTO list()
    {
        List<StakeholderResponseDTO> response = stakeholderRepository.findAll(PageRequest.of(0, 5))
                .getContent().stream().map(stakeholderMapper::toResponseDTO).collect(Collectors.toList());
        return new StakeholderListDTO(response, response.size());
    }

    public StakeholderResponseDTO add(StakeholderRequestDTO requestBody)
    {
        Stakeholder stakeholder = stakeholderRepository.save(stakeholderMapper.toModel(requestBody));
        return stakeholderMapper.toResponseDTO(stakeholder);
    }

    public StakeholderResponseDTO update(Long id, StakeholderRequestDTO requestBody)
    {
        return stakeholderRepository.findById(id)
            .map(stakeholder ->
                {
                    stakeholder.setFullName(requestBody.getFullName());
                    stakeholder.setShortName(requestBody.getShortName());
                    stakeholder.setPhone(requestBody.getPhone());
                    stakeholder.setEmail(requestBody.getEmail());
                    stakeholder.setContactFace(requestBody.getContactFace());
                    stakeholder.setType(requestBody.getType());
                    return stakeholderMapper.toResponseDTO(stakeholderRepository.save(stakeholder));
                })
            .orElseThrow(NullPointerException::new);
    }

    public void delete(Long id)
    {
        stakeholderRepository.deleteById(id);
    }

    public StakeholderResponseDTO findById(Long id)
    {
        Stakeholder stakeholder = stakeholderRepository.findById(id).orElseThrow(NullPointerException::new);
        return stakeholderMapper.toResponseDTO(stakeholder);
    }
}
