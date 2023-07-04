package solvo.yardman.models.dto.response.aSample;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class ASampleListDTO
{
    private final List<ASampleResponseDTO> aSampleList;

    private final int size;
}
