package solvo.yardman.models.dto.response.stakeholder;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class StakeholderListDTO {

    private final List<StakeholderResponseDTO> stakeholderList;

    private final int size;

}
