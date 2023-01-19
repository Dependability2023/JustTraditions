package it.unisa.justTraditions.applicationLogic.gestioneProfiliControl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/visualizzazioneProfiloPersonale")
public class VisualizzazioneProfiloPersonaleController {

  private static final String visualizzazioneProfiloPersonaleView =
      "gestioneProfiliView/visualizzazioneProfiloPersonale";

  @GetMapping
  public ModelAndView get() {
    return new ModelAndView(visualizzazioneProfiloPersonaleView);
  }
}

