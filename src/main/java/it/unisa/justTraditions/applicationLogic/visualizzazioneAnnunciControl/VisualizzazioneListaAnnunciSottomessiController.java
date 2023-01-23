package it.unisa.justTraditions.applicationLogic.visualizzazioneAnnunciControl;

import it.unisa.justTraditions.applicationLogic.autenticazioneControl.util.SessionCliente;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.entity.Artigiano;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/visualizzazioneListaAnnunciSottomessi")
public class VisualizzazioneListaAnnunciSottomessiController {

  private static final String visualizzazioneListaAnnunciSottomessiView =
      "visualizzazioneAnnunciView/visualizzazioneListaAnnunciSottomessi";
  @Autowired
  private SessionCliente sessionCliente;


  @GetMapping
  public ModelAndView get() {
    Artigiano artigiano = (Artigiano) sessionCliente.getCliente().get();
    return new ModelAndView(visualizzazioneListaAnnunciSottomessiView)
            .addObject("annunci", artigiano.getAnnunci());
  }
}