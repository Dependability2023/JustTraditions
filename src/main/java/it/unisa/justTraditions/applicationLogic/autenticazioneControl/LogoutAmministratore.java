package it.unisa.justTraditions.applicationLogic.autenticazioneControl;

import it.unisa.justTraditions.applicationLogic.autenticazioneControl.util.SessionAmministratore;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logoutAmministratore")
public class LogoutAmministratore {
  @Autowired
  SessionAmministratore sessionAmministratore;

  @GetMapping

  public String get(HttpSession session) {
    sessionAmministratore.setAmministratore(null);
    return "redirect:/loginAmministratore";
  }
}
