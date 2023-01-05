package it.unisa.justTraditions.applicationLogic.autenticazioneControl;

import it.unisa.justTraditions.applicationLogic.autenticazioneControl.util.AutenticazioneAmministratore;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/loginAmministratore")
public class LogoutAmministratore {
  @GetMapping
  public String get(HttpSession session) {
    AutenticazioneAmministratore.setAmministratore(session, null);
    return "redirect:/loginAmministratore";
  }
}
