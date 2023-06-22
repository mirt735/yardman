package solvo.declarantportal.controllers.base;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import solvo.declarantportal.models.dto.response.car.CarListDTO;
import solvo.declarantportal.services.crud.CarService;

@Slf4j
@Controller(value = "CarController")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("/car/list")
    public String list(Model model)
    {
        String pageName = "cars";
        CarListDTO cars = carService.list();
        model.addAttribute("cars", cars.getCarList());
        model.addAttribute("currentPageName", pageName);

        return pageName;
    }

}
