package pl.coderslab.web_parser_with_sb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.web_parser_with_sb.model.sections.Automotive;
import pl.coderslab.web_parser_with_sb.repository.AutomotiveRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/automotive")
public class AutomotiveController {

    private final AutomotiveRepository automotiveRepository;

    public AutomotiveController(AutomotiveRepository automotiveRepository) {
        this.automotiveRepository = automotiveRepository;
    }

    @RequestMapping("/all")
    public String showAllAutomotive(Model model) {
        List<Automotive> automotives = automotiveRepository.findAllByOrderByCreated();
        model.addAttribute("automotive", automotives);
        return "automotive/automotiveBasicView";
    }

    @GetMapping("/add")
    public String getAddAutomotive(Automotive automotive, Model model) {
        return "automotive/automotiveAdd";
    }

    @PostMapping("/add")
    public String postAddAutomotive(@Valid Automotive automotive, BindingResult result) {
        if (result.hasErrors()) {
            return "Errors/generalError";
        }
        automotiveRepository.save(automotive);
        return "redirect:/automotive/automotiveBasicView";
    }

    @GetMapping("/edit/{id}")
    public String getEditAutomotive(@PathVariable Long id, Model model) {
        model.addAttribute("automotive", automotiveRepository.findById(id));
        return "automotive/automotiveEdit";
    }

    @PostMapping("/edit/{id}")
    public String postEditAutomotive(@Valid Automotive automotive, BindingResult result) {
        if (result.hasErrors()) {
            return "Errors/generalError";
        }
        automotiveRepository.save(automotive);
        return "redirect:/automotive/automotiveBasicView";
    }

    @RequestMapping("/delete/{id}")
    public String deleteAutomotive(@PathVariable Long id) {
        automotiveRepository.deleteById(id);
        return "redirect:/automotive/automotiveBasicView";
    }
}
