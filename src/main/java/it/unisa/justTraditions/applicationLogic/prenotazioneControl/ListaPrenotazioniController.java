package it.unisa.justTraditions.applicationLogic.prenotazioneControl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/listaprenotazioni")
public class ListaPrenotazioniController {


  @GetMapping
  public ModelAndView get() {


    return new ModelAndView("prenotazioneView/listaprenotazioni");
  }
}

