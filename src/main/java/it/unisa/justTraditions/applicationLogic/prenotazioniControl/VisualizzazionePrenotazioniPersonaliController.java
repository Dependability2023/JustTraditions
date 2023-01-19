package it.unisa.justTraditions.applicationLogic.prenotazioniControl;


import it.unisa.justTraditions.applicationLogic.autenticazioneControl.util.SessionCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/visualizzazionePrenotazioniPersonali")
public class VisualizzazionePrenotazioniPersonaliController {

  private static final String visualizzazionePrenotazioniPersonaliView =
      "prenotazioniView/visualizzazionePrenotazioniPersonali";

  @Autowired
  private SessionCliente sessionCliente;

  @GetMapping
  public ModelAndView get() {
    return new ModelAndView(visualizzazionePrenotazioniPersonaliView)
        .addObject("prenotazioni", sessionCliente.getCliente().get().getPrenotazioni());
  }
}
