package it.unisa.justTraditions.applicationLogic.visualizzazioneAnnunciControl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/homeAmministratore")
public class HomeAmministratoreController {

  private static final String homeAmministratoreView =
      "visualizzazioneAnnunciView/homeAmministratore";

  @GetMapping
  public String get() {
    return homeAmministratoreView;
  }
}

