package it.unisa.justTraditions.applicationLogic.prenotazioneControl;


import it.unisa.justTraditions.applicationLogic.autenticazioneControl.util.SessionCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/prenotazioniUtente")
public class VisualizzazionePrenotazioniPersonaliController {
  @Autowired
  private SessionCliente sessionCliente;

  private static final String visualizzazionePrenotazioniPersonali =
      "prenotazioneView/visualizzazionePrenotazioniPersonali";


  @GetMapping
  public ModelAndView get() {
    return new ModelAndView(visualizzazionePrenotazioniPersonali)
        .addObject("prenotazioni", sessionCliente.getCliente().get().getPrenotazioni());
  }
}
