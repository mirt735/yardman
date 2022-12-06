package solvo.yardman.models.dto.response.cartype;

import lombok.Getter;
import lombok.Setter;
import solvo.yardman.models.dto.response.car.CarResponseDTO;

import java.util.List;

@Getter
@Setter
public class CarTypeResponseDTO {

    private Long id;

    private String name;

    private String kind;

    private Double loadCapacity;

    private Double volume;

    private Double length;

    private Double width;

    private Double height;

}
