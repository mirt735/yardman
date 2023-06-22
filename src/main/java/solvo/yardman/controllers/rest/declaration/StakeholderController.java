package solvo.yardman.controllers.rest.declaration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import solvo.yardman.models.dto.request.declaration.StakeholderRequestDTO;
import solvo.yardman.models.dto.response.declaration.StakeholderListDTO;
import solvo.yardman.models.dto.response.declaration.StakeholderResponseDTO;
import solvo.yardman.services.crud.StakeholderService;

@Slf4j
@RestController
@RequestMapping("/api")
public class StakeholderController {

    @Autowired
    private StakeholderService stakeholderService;

    @GetMapping("/stakeholder/list")
    public ResponseEntity<StakeholderListDTO> list()
    {
        return ResponseEntity.ok().body(stakeholderService.list());
    }

    @GetMapping("/stakeholder/{id}")
    public ResponseEntity<StakeholderResponseDTO> findById(@PathVariable Long id)
    {
        return ResponseEntity.ok().body(stakeholderService.findById(id));
    }

    @PostMapping("/stakeholder/add")
    public ResponseEntity<StakeholderResponseDTO> add(@RequestBody StakeholderRequestDTO requestBody)
    {
        return ResponseEntity.ok().body(stakeholderService.add(requestBody));
    }

    @PutMapping("/stakeholder/update/{id}")
    public ResponseEntity<StakeholderResponseDTO> update(@PathVariable Long id, @RequestBody StakeholderRequestDTO requestBody)
    {
        return ResponseEntity.ok().body(stakeholderService.update(id, requestBody));
    }

    //TODO DELETE OR POST ?
    @DeleteMapping("/stakeholder/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id)
    {
        stakeholderService.delete(id);
        return ResponseEntity.ok().build();
    }

}
