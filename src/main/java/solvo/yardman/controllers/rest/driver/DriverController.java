package solvo.yardman.controllers.rest.driver;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import solvo.yardman.models.dto.request.driver.DriverRequestDTO;
import solvo.yardman.models.dto.response.driver.DriverListDTO;
import solvo.yardman.models.dto.response.driver.DriverResponseDTO;
import solvo.yardman.services.crud.DriverService;
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class DriverController {

    private final DriverService driverService;

    @GetMapping("/driver/list")
    public ResponseEntity<DriverListDTO> list()
    {
        return ResponseEntity.ok().body(driverService.list());
    }

    @GetMapping("/driver/{id}")
    public ResponseEntity<DriverResponseDTO> findById(@PathVariable Long id)
    {
        return ResponseEntity.ok().body(driverService.findById(id));
    }

    @PostMapping("/driver/add")
    public ResponseEntity<DriverResponseDTO> add(@RequestBody DriverRequestDTO requestBody)
    {
        return ResponseEntity.ok().body(driverService.add(requestBody));
    }

    @PutMapping("/driver/update/{id}")
    public ResponseEntity<DriverResponseDTO> update(@PathVariable Long id, @RequestBody DriverRequestDTO requestBody)
    {
        return ResponseEntity.ok().body(driverService.update(id, requestBody));
    }

    //TODO DELETE OR POST ?
    @DeleteMapping("/driver/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id)
    {
        driverService.delete(id);
        return ResponseEntity.ok().build();
    }

}
