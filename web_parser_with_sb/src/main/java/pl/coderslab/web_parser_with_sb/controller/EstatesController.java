package pl.coderslab.web_parser_with_sb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.web_parser_with_sb.model.sections.Estates;
import pl.coderslab.web_parser_with_sb.model.sections.Estates;
import pl.coderslab.web_parser_with_sb.repository.ElectronicsRepository;
import pl.coderslab.web_parser_with_sb.repository.EstatesRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/estates")
public class EstatesController {

    private final EstatesRepository estatesRepository;

    public EstatesController(EstatesRepository estatesRepository) {
        this.estatesRepository = estatesRepository;
    }

    @RequestMapping("/all")
    public String showAllEstates(Model model) {
        List<Estates> estates = estatesRepository.findAllByOrderByCreated();
        model.addAttribute("estates", estates);
        return "estates/estatesBasicView";
    }

    @GetMapping("/add")
    public String getAddEstates(Estates estates, Model model) {
        return "estates/estatesAdd";
    }

    @PostMapping("/add")
    public String postAddEstates(@Valid Estates estates, BindingResult result) {
        if (result.hasErrors()) {
            return "Errors/generalError";
        }
        estatesRepository.save(estates);
        return "redirect:/estates/estatesBasicView";
    }

    @GetMapping("/edit/{id}")
    public String getEditEstates(@PathVariable Long id, Model model) {
        model.addAttribute("estates", estatesRepository.findById(id));
        return "estates/estatesEdit";
    }

    @PostMapping("/edit/{id}")
    public String postEditEstates(@Valid Estates estates, BindingResult result) {
        if (result.hasErrors()) {
            return "Errors/generalError";
        }
        estatesRepository.save(estates);
        return "redirect:/estates/estatesBasicView";
    }

    @RequestMapping("/delete/{id}")
    public String deleteEstates(@PathVariable Long id) {
        estatesRepository.deleteById(id);
        return "redirect:/estates/estatesBasicView";
    }
}
