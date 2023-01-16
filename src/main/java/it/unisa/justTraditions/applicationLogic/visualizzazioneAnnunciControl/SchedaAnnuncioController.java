package it.unisa.justTraditions.applicationLogic.visualizzazioneAnnunciControl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/schedaAnnuncio")
public class SchedaAnnuncioController {


  @GetMapping
  public ModelAndView get() {


    return new ModelAndView("visualizzazioneAnnunciView/visualizzazioneSchedaAnnuncio");
  }
}

