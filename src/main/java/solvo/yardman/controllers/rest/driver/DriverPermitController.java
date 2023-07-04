package solvo.yardman.controllers.rest.driver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import solvo.yardman.models.dto.request.driverPermit.DriverPermitRequestDTO;
import solvo.yardman.models.dto.response.driverPermit.DriverPermitListDTO;
import solvo.yardman.models.dto.response.driverPermit.DriverPermitResponseDTO;
import solvo.yardman.services.crud.DriverPermitService;

@Slf4j
@RestController
@RequestMapping("/api")
public class DriverPermitController {

    @Autowired
    private DriverPermitService driverPermitService;

    @GetMapping("/driver/permit/list")
    public ResponseEntity<DriverPermitListDTO> list()
    {
        return ResponseEntity.ok().body(driverPermitService.list());
    }

    @GetMapping("/driver/{driver_id}/permit/list")
    public ResponseEntity<DriverPermitListDTO> list(@PathVariable(name = "driver_id") Long driverID)
    {
        return ResponseEntity.ok().body(driverPermitService.list(driverID));
    }

    @GetMapping("/driver/permit/{id}")
    public ResponseEntity<DriverPermitResponseDTO> findById(@PathVariable Long id)
    {
        return ResponseEntity.ok().body(driverPermitService.findById(id));
    }

    @PostMapping("/driver/{driver_id}/permit/add")
    public ResponseEntity<DriverPermitResponseDTO> add(@PathVariable(name = "driver_id") Long driverId, @RequestBody DriverPermitRequestDTO requestBody)
    {
        return ResponseEntity.ok().body(driverPermitService.add(driverId, requestBody));
    }

    @PutMapping("/driver/{driver_id}/permit/update/{id}")
    public ResponseEntity<DriverPermitResponseDTO> update(@PathVariable(name = "driver_id") Long driverId, @PathVariable Long id, @RequestBody DriverPermitRequestDTO requestBody)
    {
        return ResponseEntity.ok().body(driverPermitService.update(driverId, id, requestBody));
    }

    //TODO DELETE OR POST ?
    @DeleteMapping("/driver/permit/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id)
    {
        driverPermitService.delete(id);
        return ResponseEntity.ok().build();
    }
}
