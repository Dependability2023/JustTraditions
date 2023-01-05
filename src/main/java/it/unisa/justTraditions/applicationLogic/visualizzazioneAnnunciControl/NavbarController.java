package it.unisa.justTraditions.applicationLogic.visualizzazioneAnnunciControl;

import it.unisa.justTraditions.applicationLogic.util.Province;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/navbar")
public class NavbarController {
  public ModelAndView navbar() {
    return new ModelAndView("fragment/navbar")
        .addObject("province", Province.getProvince());
  }

}
