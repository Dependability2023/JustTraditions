package it.unisa.justTraditions.applicationLogic.prenotazioniControl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/visualizzazionePrenotazioniAnnuncio")
public class VisualizzazionePrenotazioniAnnuncioController {

  private static final String visualizzazionePrenotazioniAnnuncioView =
      "prenotazioniView/visualizzazionePrenotazioniAnnuncio";

  @GetMapping
  public ModelAndView get() {
    return new ModelAndView(visualizzazionePrenotazioniAnnuncioView);
  }
}

