package it.unisa.justTraditions.applicationLogic.autenticazioneControl;

import it.unisa.justTraditions.applicationLogic.autenticazioneControl.form.LoginForm;
import it.unisa.justTraditions.applicationLogic.autenticazioneControl.util.AutenticazioneCliente;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.dao.ClienteDao;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.entity.Cliente;
import jakarta.servlet.http.HttpSession;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {
  @Autowired
  ClienteDao clienteDao;

  @GetMapping
  public ModelAndView get() {
    return new ModelAndView("autenticazioneView/login")
        .addObject("loginForm", new LoginForm())
        .addObject("errorLogin", false);
  }

  @PostMapping
  public ModelAndView post(@ModelAttribute LoginForm loginForm, HttpSession session) {
    System.out.println("Email:" + loginForm.getEmail());
    System.out.println("Passworld:" + loginForm.getPassworld());

    Optional<Cliente> cliente = clienteDao.findByEmail(loginForm.getEmail());
    if (cliente.isEmpty()) {
      return new ModelAndView("autenticazioneView/login")
          .addObject("loginForm", new LoginForm())
          .addObject("errorLogin", true);
    }
    AutenticazioneCliente.setCliente(session, cliente.orElseThrow());
    return new ModelAndView("visualizzazioneAnnunciView/home");


  }
}
