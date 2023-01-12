package it.unisa.justTraditions.applicationLogic.autenticazioneControl;

import it.unisa.justTraditions.applicationLogic.autenticazioneControl.form.LoginForm;
import it.unisa.justTraditions.applicationLogic.autenticazioneControl.util.PasswordEncryptor;
import it.unisa.justTraditions.applicationLogic.autenticazioneControl.util.SessionAmministratore;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.dao.AmministratoreDao;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.entity.Amministratore;
import jakarta.validation.Valid;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/loginAmministratore")
public class LoginAmministratoreController {

  @Autowired
  private AmministratoreDao amministratoreDao;

  @Autowired
  private SessionAmministratore sessionAmministratore;

  @Autowired
  private PasswordEncryptor passwordEncryptor;

  @GetMapping
  public String get(@ModelAttribute LoginForm loginForm) {
    return "autenticazioneView/loginAmministratore";
  }

  @PostMapping
  public String post(@ModelAttribute @Valid LoginForm loginForm,
                     BindingResult bindingResult, Model model) {
    if (bindingResult.hasErrors()) {
      return "autenticazioneView/loginAmministratore";
    }

    Optional<Amministratore> optionalAmministratore =
        amministratoreDao.findByEmail(loginForm.getEmail());

    if (optionalAmministratore.isEmpty()) {
      model.addAttribute("existsEmail", false);
      return "autenticazioneView/loginAmministratore";
    }

    Amministratore amministratore = optionalAmministratore.get();
    if (passwordEncryptor.checkPassword(loginForm.getPassword(), amministratore.getPassword())) {
      sessionAmministratore.setAmministratore(amministratore);
    } else {
      model.addAttribute("passwordErrata", true);
      return "autenticazioneView/loginAmministratore";
    }

    return "redirect:/homeAmministratore";
  }
}
