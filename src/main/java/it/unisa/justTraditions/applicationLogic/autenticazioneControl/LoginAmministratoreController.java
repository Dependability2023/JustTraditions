package it.unisa.justTraditions.applicationLogic.autenticazioneControl;

import it.unisa.justTraditions.applicationLogic.autenticazioneControl.form.LoginForm;
import it.unisa.justTraditions.applicationLogic.autenticazioneControl.util.AutenticazioneAmministratore;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.dao.AmministratoreDao;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.entity.Amministratore;
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
@RequestMapping("/loginAmministratore")
public class LoginAmministratoreController {

  @Autowired
  AmministratoreDao amministratoreDao;

  @GetMapping
  public ModelAndView get() {
    return new ModelAndView("autenticazioneView/loginAmministratore")
        .addObject("loginForm", new LoginForm())
        .addObject("errorLogin", false);
  }

  @PostMapping
  public ModelAndView post(@ModelAttribute LoginForm loginForm, HttpSession session) {
    System.out.println("Email:" + loginForm.getEmail());
    System.out.println("Passworld:" + loginForm.getPassworld());

    Optional<Amministratore> amministratore = amministratoreDao.findByEmail(loginForm.getEmail());
    if (amministratore.isEmpty()) {
      return new ModelAndView("autenticazioneView/login")
          .addObject("loginForm", new LoginForm())
          .addObject("errorLogin", true);
    }
    AutenticazioneAmministratore.setAmministratore(session, amministratore.orElseThrow());
    return new ModelAndView("??");


  }
}
