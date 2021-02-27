package pl.coderslab.web_parser_with_sb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.web_parser_with_sb.model.sections.Services;
import pl.coderslab.web_parser_with_sb.repository.ServicesRepository;
import pl.coderslab.web_parser_with_sb.repository.ServicesRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/services")
public class ServicesController {

    private final ServicesRepository servicesRepository;

    public ServicesController(ServicesRepository servicesRepository) {
        this.servicesRepository = servicesRepository;
    }

    @RequestMapping("/all")
    public String showAllServices(Model model) {
        List<Services> services = servicesRepository.findAllByOrderByCreated();
        model.addAttribute("services", services);
        return "services/servicesBasicView";
    }

    @GetMapping("/add")
    public String getAddServices(Services services, Model model) {
        return "services/servicesAdd";
    }

    @PostMapping("/add")
    public String postAddServices(@Valid Services services, BindingResult result) {
        if (result.hasErrors()) {
            return "Errors/generalError";
        }
        servicesRepository.save(services);
        return "redirect:/services/servicesBasicView";
    }

    @GetMapping("/edit/{id}")
    public String getEditServices(@PathVariable Long id, Model model) {
        model.addAttribute("services", servicesRepository.findById(id));
        return "services/servicesEdit";
    }

    @PostMapping("/edit/{id}")
    public String postEditServices(@Valid Services services, BindingResult result) {
        if (result.hasErrors()) {
            return "Errors/generalError";
        }
        servicesRepository.save(services);
        return "redirect:/services/servicesBasicView";
    }

    @RequestMapping("/delete/{id}")
    public String deleteServices(@PathVariable Long id) {
        servicesRepository.deleteById(id);
        return "redirect:/services/servicesBasicView";
    }
}
