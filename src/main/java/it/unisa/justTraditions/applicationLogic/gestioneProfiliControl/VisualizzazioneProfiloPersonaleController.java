package it.unisa.justTraditions.applicationLogic.gestioneProfiliControl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Implementa il controller per la visualizzazione del profilo personale di un Cliente.
 */
@Controller
@RequestMapping("/visualizzazioneProfiloPersonale")
public class VisualizzazioneProfiloPersonaleController {

  private static final String visualizzazioneProfiloPersonaleView =
      "gestioneProfiliView/visualizzazioneProfiloPersonale";

  /**
   * Implementa la funzionalità di smistare il Cliente
   * su la view di gestioneProfiliView/visualizzazioneProfiloPersonale.
   *
   * @return gestioneProfiliView/visualizzazioneProfiloPersonale.
   */
  @GetMapping
  public String get() {
    return visualizzazioneProfiloPersonaleView;
  }
}

