package solvo.yardman.controllers.base;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import solvo.yardman.models.dto.response.driver.DriverListDTO;
import solvo.yardman.services.crud.DriverService;

@Slf4j
@Controller(value = "DriverController")
@RequiredArgsConstructor
public class DriverController {

    private final DriverService driverService;

    @GetMapping("/driver/list")
    public String list(Model model)
    {
        String pageName = "drivers";
        DriverListDTO drivers = driverService.list();
        model.addAttribute("drivers", drivers.getDriverList());
        model.addAttribute("currentPageName", pageName);

        return pageName;
    }

}
