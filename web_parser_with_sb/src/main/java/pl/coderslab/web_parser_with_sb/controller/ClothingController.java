package pl.coderslab.web_parser_with_sb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.web_parser_with_sb.model.sections.Automotive;
import pl.coderslab.web_parser_with_sb.model.sections.Clothing;
import pl.coderslab.web_parser_with_sb.repository.AutomotiveRepository;
import pl.coderslab.web_parser_with_sb.repository.ClothingRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/clothing")
public class ClothingController {

    private final ClothingRepository clothingRepository;

    public ClothingController(ClothingRepository clothingRepository) {
        this.clothingRepository = clothingRepository;
    }

    @RequestMapping("/all")
    public String showAllClothing(Model model) {
        List<Clothing> clothings = clothingRepository.findAllByOrderByCreated();
        model.addAttribute("automotive", clothings);
        return "clothing/clothingBasicView";
    }

    @GetMapping("/add")
    public String getAddClothing(Clothing clothing, Model model) {
        return "clothing/clothingAdd";
    }

    @PostMapping("/add")
    public String postAddClothing(@Valid Clothing clothing, BindingResult result) {
        if (result.hasErrors()) {
            return "Errors/generalError";
        }
        clothingRepository.save(clothing);
        return "redirect:/clothing/clothingBasicView";
    }

    @GetMapping("/edit/{id}")
    public String getEditClothing(@PathVariable Long id, Model model) {
        model.addAttribute("automotive", clothingRepository.findById(id));
        return "clothing/clothingEdit";
    }

    @PostMapping("/edit/{id}")
    public String postEditClothing(@Valid Clothing clothing, BindingResult result) {
        if (result.hasErrors()) {
            return "Errors/generalError";
        }
        clothingRepository.save(clothing);
        return "redirect:/clothing/clothingBasicView";
    }

    @RequestMapping("/delete/{id}")
    public String deleteClothing(@PathVariable Long id) {
        clothingRepository.deleteById(id);
        return "redirect:/clothing/clothingBasicView";
    }
}
