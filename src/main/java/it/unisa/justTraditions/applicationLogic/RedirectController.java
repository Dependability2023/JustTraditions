package it.unisa.justTraditions.applicationLogic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/redirectController")
public class RedirectController {

  @GetMapping
  public String get() {
    return "autenticazioneView/registrazione";
  }
}
