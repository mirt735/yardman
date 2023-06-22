package solvo.declarantportal.controllers.base;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import solvo.declarantportal.models.dto.response.declaration.StakeholderListDTO;
import solvo.declarantportal.services.crud.StakeholderService;

@Slf4j
@Controller(value = "StakeholderController")
@RequiredArgsConstructor
public class StakeholderController {

    private final StakeholderService stakeholderService;

    @GetMapping("/stakeholder/list")
    public String list(Model model)
    {
        String pageName = "stakeholders";
        StakeholderListDTO stakeholders = stakeholderService.list();
        model.addAttribute("stakeholders", stakeholders.getStakeholderList());
        model.addAttribute("currentPageName", pageName);

        return pageName;
    }

}
