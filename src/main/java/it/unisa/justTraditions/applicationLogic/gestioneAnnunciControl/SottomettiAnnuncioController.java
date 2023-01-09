package it.unisa.justTraditions.applicationLogic.gestioneAnnunciControl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sottomettiannuncio")
public class SottomettiAnnuncioController {


  @GetMapping
  public ModelAndView get() {


    return new ModelAndView("gestioneAnnunciView/sottomettiannuncio");
  }
}

