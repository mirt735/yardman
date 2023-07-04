package solvo.yardman.models.dto.request.aSample;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ASampleRequestDTO
{
    private String sampleString;

    private Integer sampleInteger;

    private LocalDateTime sampleDate;

    private LocalDateTime sampleTime;

    private boolean sampleBoolean;

    private String sampleEmail;

    private Integer sampleIntegerSelectValue;

    private Integer sampleStringSelectValue;
}
