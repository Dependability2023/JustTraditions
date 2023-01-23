package it.unisa.justTraditions.applicationLogic.prenotazioniControl;

import java.sql.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/visualizzazionePrenotazioniAnnuncio")
public class VisualizzazionePrenotazioniAnnuncioController {

  private static final String visualizzazionePrenotazioniAnnuncioView =
      "prenotazioniView/visualizzazionePrenotazioniAnnuncio";

  @GetMapping
  public ModelAndView get(@RequestParam(required = false) String ricercaAttivita, Date date) {
    System.out.println(ricercaAttivita + date);
    return new ModelAndView(visualizzazionePrenotazioniAnnuncioView).addObject("Prenotazioni");
  }
}

