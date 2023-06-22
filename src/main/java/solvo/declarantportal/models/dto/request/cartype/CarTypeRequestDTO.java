package solvo.declarantportal.models.dto.request.cartype;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarTypeRequestDTO {

    private String name;

    private String kind;

    private Double loadCapacity;

    private Double volume;

    private Double length;

    private Double width;

    private Double height;

}
