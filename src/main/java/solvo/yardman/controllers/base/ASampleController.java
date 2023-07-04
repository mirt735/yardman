package solvo.yardman.controllers.base;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import solvo.yardman.models.dto.request.aSample.ASampleRequestDTO;
import solvo.yardman.models.dto.response.aSample.ASampleResponseDTO;
import solvo.yardman.services.crud.ASampleService;

import java.util.List;

@Slf4j
@Controller(value = "ASampleController")
@RequiredArgsConstructor
public class ASampleController
{
    private final ASampleService aSampleService;

    @GetMapping("/asample/new")
    public String createNewSampleForm(Model model)
    {
        String pageName = "asample";
        ASampleResponseDTO aSample = new ASampleResponseDTO();
        model.addAttribute("asample", aSample);

        return pageName + "/create";
    }

    @PostMapping("/asample/list")
    public String createASample(@ModelAttribute("asample") ASampleRequestDTO aSampleRequestDTO)
    {
        aSampleService.add(aSampleRequestDTO);
        return "redirect:/asample/list";
    }

    @GetMapping("/asample/edit/{id}")
    public String updateASampleForm(@PathVariable Long id, Model model)
    {
        String pageName = "asample";
        model.addAttribute("student", aSampleService.findById(id));
        return  pageName + "/edit";
    }

    @PostMapping("/asample/{id}")
    public String updateASample(@PathVariable Long id,
                                @ModelAttribute("asample") ASampleRequestDTO aSampleRequestDTO,
                                Model model)
    {
        aSampleService.update(id, aSampleRequestDTO);
        return "redirect:/asample/list";
    }

    @GetMapping("/asample/list/{id}")
    public String deleteASample(@PathVariable Long id)
    {
        aSampleService.delete(id);
        return "redirect:/asample/list";
    }

    //TODO add view

    @GetMapping("/asample/list")
    public String list(Model model)
    {
        return findPaginated(1, model);
    }

    @GetMapping("/asample/list/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model)
    {
        String pageName = "asamples";
        int pageSize = 5;

        Page<ASampleResponseDTO> page = aSampleService.findPaginated(pageNo, pageSize);
        List<ASampleResponseDTO> aSampleList = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("aSampleList", aSampleList);
        model.addAttribute("currentPageName", pageName);

        return pageName;
    }
}
