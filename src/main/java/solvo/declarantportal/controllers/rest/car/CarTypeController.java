package solvo.declarantportal.controllers.rest.car;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import solvo.declarantportal.models.dto.request.cartype.CarTypeRequestDTO;
import solvo.declarantportal.models.dto.response.cartype.CarTypeListDTO;
import solvo.declarantportal.models.dto.response.cartype.CarTypeResponseDTO;
import solvo.declarantportal.services.crud.CarTypeService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CarTypeController {

    private final CarTypeService carTypeService;

    @GetMapping("/car/type/list")
    public ResponseEntity<CarTypeListDTO> list()
    {
        return ResponseEntity.ok().body(carTypeService.list());
    }


    @GetMapping("/car/type/{id}")
    public ResponseEntity<CarTypeResponseDTO> findById(@PathVariable Long id)
    {
        return ResponseEntity.ok().body(carTypeService.findById(id));
    }

    @PostMapping("/car/type/add")
    public ResponseEntity<CarTypeResponseDTO> add(@RequestBody CarTypeRequestDTO requestBody)
    {
        return ResponseEntity.ok().body(carTypeService.add(requestBody));
    }

    @PutMapping("/car/type/{id}")
    public ResponseEntity<CarTypeResponseDTO> update(@PathVariable(name = "id") Long carTypeId,
                                                          @RequestBody CarTypeRequestDTO requestBody)
    {
        return ResponseEntity.ok().body(carTypeService.update(carTypeId, requestBody));
    }

    @DeleteMapping("/car/type/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id)
    {
        carTypeService.delete(id);
        return ResponseEntity.ok().build();
    }
}
