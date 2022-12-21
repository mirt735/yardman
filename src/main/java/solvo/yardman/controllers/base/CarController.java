package solvo.yardman.controllers.base;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import solvo.yardman.models.dto.response.car.CarListDTO;
import solvo.yardman.services.crud.CarService;

@Slf4j
@Controller(value = "CarController")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("/car/list")
    public String list(Model model)
    {
        CarListDTO cars = carService.getAll();
        model.addAttribute("cars", cars.getCarList());

        return "cars";
    }

}
