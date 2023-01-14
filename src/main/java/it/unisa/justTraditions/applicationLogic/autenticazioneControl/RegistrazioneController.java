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
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("registrazione")
public class RegistrazioneController {
  @Autowired
  private ClienteDao clienteDao;
  @Autowired
  private ArtigianoDao artigianoDao;
  @Autowired
  private PasswordEncryptor passwordEncryptor;

  @GetMapping
  public ModelAndView get() {
    return new ModelAndView("autenticazioneView/registrazione")
        .addObject("registrazioneForm", new RegistrazioneForm());
  }

  @PostMapping
  public ModelAndView post(@ModelAttribute @Valid RegistrazioneForm registrazioneForm,
                           BindingResult bindingResult) {
    Cliente cliente;
    Artigiano artigiano;
    if (bindingResult.hasErrors()) {

      return new ModelAndView("autenticazioneView/registrazione");
    }

    if (registrazioneForm.isArtigiano()) {
      artigiano = new Artigiano(
          registrazioneForm.getEmail(),
          passwordEncryptor.encryptPassword(registrazioneForm.getPassword()),
          registrazioneForm.getNome(),
          registrazioneForm.getCognome(),
          registrazioneForm.getCodiceFiscale(),
          registrazioneForm.getIban());
      artigianoDao.save(artigiano);
      System.out.println(artigiano);
    } else {
      cliente = new Cliente(
          registrazioneForm.getEmail(),
          passwordEncryptor.encryptPassword(registrazioneForm.getPassword()),
          registrazioneForm.getNome(),
          registrazioneForm.getCognome(),
          registrazioneForm.getCodiceFiscale());
      clienteDao.save(cliente);
      System.out.println(cliente);
    }


    return new ModelAndView("redirect:/login");
  }

}
