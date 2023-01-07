package it.unisa.justTraditions.applicationLogic.autenticazioneControl;

import it.unisa.justTraditions.applicationLogic.autenticazioneControl.form.LoginForm;
import it.unisa.justTraditions.applicationLogic.autenticazioneControl.util.SessionAmministratore;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.dao.AmministratoreDao;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.entity.Amministratore;
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
  @Autowired
  SessionAmministratore sessionAmministratore;

  @GetMapping
  public ModelAndView get() {
    return new ModelAndView("autenticazioneView/loginAmministratore")
        .addObject("loginForm", new LoginForm())
        .addObject("errorLogin", false);
  }

  @PostMapping
  public ModelAndView post(@ModelAttribute LoginForm loginForm) {
    Optional<Amministratore> amministratore = amministratoreDao.findByEmail(loginForm.getEmail());
    if (amministratore.isEmpty()) {
      return new ModelAndView("autenticazioneView/login")
          .addObject("loginForm", new LoginForm())
          .addObject("errorLogin", true);
    }
    sessionAmministratore.setAmministratore(amministratore.orElseThrow());
    return new ModelAndView("??");


  }
}
