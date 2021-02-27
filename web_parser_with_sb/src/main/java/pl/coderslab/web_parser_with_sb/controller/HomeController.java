package pl.coderslab.web_parser_with_sb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.web_parser_with_sb.model.specifics.Price;
import pl.coderslab.web_parser_with_sb.repository.*;

@Controller
public class HomeController {

    private final AutomotiveRepository automotiveRepository;
    private final BrandRepository brandRepository;
    private final ClothingRepository clothingRepository;
    private final ContactRepository contactRepository;
    private final ElectronicsRepository electronicsRepository;
    private final EstatesRepository estatesRepository;
    private final LocalizationRepository localizationRepository;
    private final ModelRepository modelRepository;
    private final PriceRepository priceRepository;
    private final ServicesRepository servicesRepository;
    private final WorkRepository workRepository;

    public HomeController(AutomotiveRepository automotiveRepository,
                          BrandRepository brandRepository,
                          ClothingRepository clothingRepository,
                          ContactRepository contactRepository,
                          ElectronicsRepository electronicsRepository,
                          EstatesRepository estatesRepository,
                          LocalizationRepository localizationRepository,
                          ModelRepository modelRepository,
                          PriceRepository priceRepository,
                          ServicesRepository servicesRepository,
                          WorkRepository workRepository) {
        this.automotiveRepository = automotiveRepository;
        this.brandRepository = brandRepository;
        this.clothingRepository = clothingRepository;
        this.contactRepository = contactRepository;
        this.electronicsRepository = electronicsRepository;
        this.estatesRepository = estatesRepository;
        this.localizationRepository = localizationRepository;
        this.modelRepository = modelRepository;
        this.priceRepository = priceRepository;
        this.servicesRepository = servicesRepository;
        this.workRepository = workRepository;
    }

    @RequestMapping("/")
    public String showAll(Model model) {
        model.addAttribute("automotive", automotiveRepository.findAllByOrderByCreated());
        model.addAttribute("automotive", clothingRepository.findAllByOrderByCreated());
        model.addAttribute("automotive", electronicsRepository.findAllByOrderByCreated());
        model.addAttribute("automotive", estatesRepository.findAllByOrderByCreated());
        model.addAttribute("automotive", servicesRepository.findAllByOrderByCreated());
        model.addAttribute("automotive", workRepository.findAllByOrderByCreated());
        return "/home";
    }
}
