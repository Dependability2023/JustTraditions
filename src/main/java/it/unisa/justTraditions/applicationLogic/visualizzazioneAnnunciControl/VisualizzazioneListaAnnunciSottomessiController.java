package it.unisa.justTraditions.applicationLogic.visualizzazioneAnnunciControl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/visualizzazioneListaAnnunciSottomessi")
public class VisualizzazioneListaAnnunciSottomessiController {

  private static final String visualizzazioneListaAnnunciSottomessiView =
      "visualizzazioneAnnunciView/visualizzazioneListaAnnunciSottomessi";

  @GetMapping
  public ModelAndView get() {
    return new ModelAndView(visualizzazioneListaAnnunciSottomessiView);
  }
}