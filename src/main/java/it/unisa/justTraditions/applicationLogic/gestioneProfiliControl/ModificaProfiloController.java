package it.unisa.justTraditions.applicationLogic.gestioneProfiliControl;

import it.unisa.justTraditions.applicationLogic.autenticazioneControl.form.RegistrazioneForm;
import it.unisa.justTraditions.applicationLogic.autenticazioneControl.util.PasswordEncryptor;
import it.unisa.justTraditions.applicationLogic.autenticazioneControl.util.SessionCliente;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.dao.ArtigianoDao;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.dao.ClienteDao;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.entity.Artigiano;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/modificaProfilo")
public class ModificaProfiloController {

  @Autowired
  private ClienteDao clienteDao;
  @Autowired
  private ArtigianoDao artigianoDao;
  @Autowired
  private PasswordEncryptor passwordEncryptor;
  @Autowired
  private SessionCliente sessionCliente;


  @GetMapping
  public ModelAndView get() {
    RegistrazioneForm registrazioneForm = new RegistrazioneForm();


    if (sessionCliente.getCliente().get().getClass() == Artigiano.class) {
      Artigiano artigiano = (Artigiano) sessionCliente.getCliente().get();
      registrazioneForm.setNome(artigiano.getNome());
      registrazioneForm.setCognome(artigiano.getCognome());
      registrazioneForm.setCodiceFiscale(artigiano.getCodiceFiscale());
      registrazioneForm.setEmail(artigiano.getEmail());
      registrazioneForm.setArtigiano(true);
      registrazioneForm.setIban(artigiano.getIban());

    } else {
      Cliente cliente = sessionCliente.getCliente().get();
      registrazioneForm.setNome(cliente.getNome());
      registrazioneForm.setCognome(cliente.getCognome());
      registrazioneForm.setCodiceFiscale(cliente.getCodiceFiscale());
      registrazioneForm.setEmail(cliente.getEmail());
      registrazioneForm.setArtigiano(false);
    }

    return new ModelAndView("gestioneProfiliView/modificaprofilo").addObject("registrazioneForm",
        registrazioneForm);
  }


}