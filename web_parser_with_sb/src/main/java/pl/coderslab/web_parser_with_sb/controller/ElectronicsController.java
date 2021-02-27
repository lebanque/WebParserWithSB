package pl.coderslab.web_parser_with_sb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.web_parser_with_sb.model.sections.Automotive;
import pl.coderslab.web_parser_with_sb.model.sections.Electronics;
import pl.coderslab.web_parser_with_sb.repository.AutomotiveRepository;
import pl.coderslab.web_parser_with_sb.repository.ElectronicsRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/electronics")
public class ElectronicsController {

    private final ElectronicsRepository electronicsRepository;

    public ElectronicsController(ElectronicsRepository electronicsRepository) {
        this.electronicsRepository = electronicsRepository;
    }

    @RequestMapping("/all")
    public String showAllElectronics(Model model) {
        List<Electronics> electronics = electronicsRepository.findAllByOrderByCreated();
        model.addAttribute("electronics", electronics);
        return "electronics/electronicsBasicView";
    }

    @GetMapping("/add")
    public String getAddElectronics(Electronics electronics, Model model) {
        return "Electronics/electronicsAdd";
    }

    @PostMapping("/add")
    public String postAddElectronics(@Valid Electronics electronics, BindingResult result) {
        if (result.hasErrors()) {
            return "Errors/generalError";
        }
        electronicsRepository.save(electronics);
        return "redirect:/electronics/electronicsBasicView";
    }

    @GetMapping("/edit/{id}")
    public String getEditElectronics(@PathVariable Long id, Model model) {
        model.addAttribute("electronics", electronicsRepository.findById(id));
        return "electronics/electronicsEdit";
    }

    @PostMapping("/edit/{id}")
    public String postEditElectronics(@Valid Electronics electronics, BindingResult result) {
        if (result.hasErrors()) {
            return "Errors/generalError";
        }
        electronicsRepository.save(electronics);
        return "redirect:/electronics/electronicsBasicView";
    }

    @RequestMapping("/delete/{id}")
    public String deleteElectronics(@PathVariable Long id) {
        electronicsRepository.deleteById(id);
        return "redirect:/electronics/electronicsBasicView";
    }
}
