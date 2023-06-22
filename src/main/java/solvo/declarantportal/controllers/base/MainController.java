package solvo.declarantportal.controllers.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class MainController {

    @GetMapping("/")
    public String main(Model model)
    {
        String pageName = "home";
        model.addAttribute("currentPageName", pageName);
        return pageName;
    }
}
