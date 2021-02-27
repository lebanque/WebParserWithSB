package pl.coderslab.web_parser_with_sb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.web_parser_with_sb.model.sections.Work;
import pl.coderslab.web_parser_with_sb.repository.WorkRepository;
import pl.coderslab.web_parser_with_sb.repository.WorkRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/work")
public class WorkController {

    private final WorkRepository workRepository;

    public WorkController(WorkRepository workRepository) {
        this.workRepository = workRepository;
    }

    @RequestMapping("/all")
    public String showAllWork(Model model) {
        List<Work> work = workRepository.findAllByOrderByCreated();
        model.addAttribute("work", work);
        return "work/workBasicView";
    }

    @GetMapping("/add")
    public String getAddWork(Work work, Model model) {
        return "work/workAdd";
    }

    @PostMapping("/add")
    public String postAddWork(@Valid Work work, BindingResult result) {
        if (result.hasErrors()) {
            return "Errors/generalError";
        }
        workRepository.save(work);
        return "redirect:/work/workBasicView";
    }

    @GetMapping("/edit/{id}")
    public String getEditWork(@PathVariable Long id, Model model) {
        model.addAttribute("work", workRepository.findById(id));
        return "work/workEdit";
    }

    @PostMapping("/edit/{id}")
    public String postEditWork(@Valid Work work, BindingResult result) {
        if (result.hasErrors()) {
            return "Errors/generalError";
        }
        workRepository.save(work);
        return "redirect:/work/workBasicView";
    }

    @RequestMapping("/delete/{id}")
    public String deleteWork(@PathVariable Long id) {
        workRepository.deleteById(id);
        return "redirect:/work/workBasicView";
    }
}
