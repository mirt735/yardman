package solvo.yardman.controllers.rest.car;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import solvo.yardman.models.dto.request.car.CarRequestDTO;
import solvo.yardman.models.dto.response.car.CarListDTO;
import solvo.yardman.models.dto.response.car.CarResponseDTO;
import solvo.yardman.services.crud.CarService;

@Slf4j
@RestController(value = "RestCarController")
@RequiredArgsConstructor
@RequestMapping("/api")
public class CarController {

    private final CarService carService;

    @GetMapping("/car/list")
    public ResponseEntity<CarListDTO> list()
    {
        return ResponseEntity.ok().body(carService.list());
    }

    @GetMapping("/car/list/{type_id}")
    public ResponseEntity<CarListDTO> listByCarType(@PathVariable Long id)
    {
        return ResponseEntity.ok().body(carService.getCarListByCarType(id));
    }

    @GetMapping("/car/{id}")
    public ResponseEntity<CarResponseDTO> findById(@PathVariable Long id)
    {
        return ResponseEntity.ok().body(carService.findById(id));
    }

    @PostMapping("/car/add")
    public ResponseEntity<CarResponseDTO> add(@RequestBody CarRequestDTO requestBody)
    {
        return ResponseEntity.ok().body(carService.add(requestBody));
    }

    @PutMapping("/car/update/{id}")
    public ResponseEntity<CarResponseDTO> update(@PathVariable Long id, @RequestBody CarRequestDTO requestBody)
    {
        return ResponseEntity.ok().body(carService.update(id, requestBody));
    }

    @DeleteMapping("/car/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id)
    {
        carService.delete(id);
        return ResponseEntity.ok().build();
    }

}
