package solvo.yardman.models.dto.request.cartype;

import lombok.Getter;
import lombok.Setter;
import solvo.yardman.models.CarType;

import javax.persistence.Column;
import java.util.List;

@Getter
@Setter
public class CarTypeRequestDTO {

    private String name;

    private String type;

    private Double capacity;

    private Double volume;

    private Double length;

    private Double width;

    private Double height;

    private List<Long> carIds;

}
