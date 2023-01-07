package it.unisa.justTraditions.applicationLogic.autenticazioneControl;

import it.unisa.justTraditions.applicationLogic.autenticazioneControl.util.SessionCliente;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout")
public class LogoutController {
  @Autowired
  SessionCliente sessionCliente;

  @GetMapping
  public String get(HttpSession session) {
    sessionCliente.setCliente(null);
    return "redirect:/";
  }
}
