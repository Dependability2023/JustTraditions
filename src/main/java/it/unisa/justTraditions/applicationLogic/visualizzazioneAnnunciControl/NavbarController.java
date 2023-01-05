package it.unisa.justTraditions.applicationLogic.visualizzazioneAnnunciControl;

import it.unisa.justTraditions.applicationLogic.util.Province;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/navbar")
public class NavbarController {
  @GetMapping
  public ModelAndView get() {
    return new ModelAndView("fragments/navbar")
        .addObject("province", Province.getProvince());
  }
}
