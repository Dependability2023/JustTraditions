package it.unisa.justTraditions.applicationLogic.gestioneProfiliControl;

import it.unisa.justTraditions.applicationLogic.autenticazioneControl.util.PasswordEncryptor;
import it.unisa.justTraditions.applicationLogic.gestioneProfiliControl.form.AggiuntaAmministratoreForm;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.dao.AmministratoreDao;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.entity.Amministratore;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/aggiuntaAmministratore")
public class AggiuntaAmministratoreController {

  private static final String aggiuntaAmministratoreView =
      "gestioneProfiliView/aggiuntaAmministratore";
  private static final String visualizzazioneAmministratoriController =
      "/visualizzazioneAmministratori";

  @Autowired
  private PasswordEncryptor passwordEncryptor;

  @Autowired
  AmministratoreDao amministratoreDao;


  @GetMapping
  public String get(@ModelAttribute AggiuntaAmministratoreForm aggiuntaAmministratoreForm) {
    return aggiuntaAmministratoreView;
  }

  @PostMapping
  public String post(@ModelAttribute @Valid AggiuntaAmministratoreForm aggiuntaAmministratoreForm,
                     BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return aggiuntaAmministratoreView;
    }

    Amministratore amministratore = new Amministratore(
        aggiuntaAmministratoreForm.getEmail(),
        passwordEncryptor.encryptPassword(aggiuntaAmministratoreForm.getPassword()),
        aggiuntaAmministratoreForm.getNome(),
        aggiuntaAmministratoreForm.getCognome()
    );
    amministratoreDao.save(amministratore);

    return "redirect:" + visualizzazioneAmministratoriController;
  }
}