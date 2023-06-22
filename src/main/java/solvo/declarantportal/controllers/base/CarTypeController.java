package solvo.declarantportal.controllers.base;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import solvo.declarantportal.models.dto.response.cartype.CarTypeListDTO;
import solvo.declarantportal.services.crud.CarTypeService;

@Slf4j
@Controller(value = "CarTypeController")
@RequiredArgsConstructor
public class CarTypeController {

    private final CarTypeService carTypeService;

    @GetMapping("/carType/list")
    public String list(Model model)
    {
        String pageName = "carTypes";
        CarTypeListDTO carTypes = carTypeService.list();
        model.addAttribute("carTypes", carTypes.getCarTypeList());
        model.addAttribute("currentPageName", pageName);

        return pageName;
    }

}
