package it.unisa.justTraditions.applicationLogic.autenticazioneControl;

import it.unisa.justTraditions.applicationLogic.autenticazioneControl.form.RegistrazioneForm;
import it.unisa.justTraditions.applicationLogic.autenticazioneControl.util.PasswordEncryptor;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.dao.ArtigianoDao;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.dao.ClienteDao;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.entity.Artigiano;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.entity.Cliente;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registrazione")
public class RegistrazioneController {

  private static final String registrazioneView = "autenticazioneView/registrazione";
  private static final String loginController = "/login";

  @Autowired
  private ClienteDao clienteDao;

  @Autowired
  private ArtigianoDao artigianoDao;

  @Autowired
  private PasswordEncryptor passwordEncryptor;

  /**
   * Implementa la funzionalità di  smistare l'Amministratore sulla view di  autenticazioneView/registrazione.
   *
   * @param registrazioneForm Utilizzato per mappare il Form della view.
   * @return autenticazioneView/registrazione.
   */
  @GetMapping
  public String get(@ModelAttribute RegistrazioneForm registrazioneForm) {
    return registrazioneView;
  }

  /**
   * Implementa la funzionalità di Registrazione di un Cliente.
   *
   * @param registrazioneForm Utilizzato per mappare il Form della view.
   * @param bindingResult     Utilizzato per mappare gli errori dei dati di RegistrazioneForm
   * @return autenticazioneView/registrazione se i dati di loginForm sono errati.
   * redirect: login la Registrazione ha avuto successo.
   */
  @PostMapping
  public String post(@ModelAttribute @Valid RegistrazioneForm registrazioneForm,
                     BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return registrazioneView;
    }

    if (registrazioneForm.isArtigiano()) {
      Artigiano artigiano = new Artigiano(
          registrazioneForm.getEmail(),
          passwordEncryptor.encryptPassword(registrazioneForm.getPassword()),
          registrazioneForm.getNome(),
          registrazioneForm.getCognome(),
          registrazioneForm.getCodiceFiscale(),
          registrazioneForm.getIban()
      );
      artigianoDao.save(artigiano);
    } else {
      Cliente cliente = new Cliente(
          registrazioneForm.getEmail(),
          passwordEncryptor.encryptPassword(registrazioneForm.getPassword()),
          registrazioneForm.getNome(),
          registrazioneForm.getCognome(),
          registrazioneForm.getCodiceFiscale()
      );
      clienteDao.save(cliente);
    }

    return "redirect:" + loginController;
  }
}
