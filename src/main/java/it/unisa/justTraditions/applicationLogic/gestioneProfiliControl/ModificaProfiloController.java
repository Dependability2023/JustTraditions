package it.unisa.justTraditions.applicationLogic.gestioneProfiliControl;

import it.unisa.justTraditions.applicationLogic.autenticazioneControl.form.RegistrazioneForm;
import it.unisa.justTraditions.applicationLogic.autenticazioneControl.util.SessionCliente;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.dao.ClienteDao;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.entity.Artigiano;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.entity.Cliente;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/modificaProfilo")
public class ModificaProfiloController {

  private static final String modificaProfiloView = "gestioneProfiliView/modificaProfilo";

  @Autowired
  private SessionCliente sessionCliente;

  @Autowired
  private ClienteDao clienteDao;

  @GetMapping
  public String get(@ModelAttribute RegistrazioneForm registrazioneForm) {
    Cliente cliente = sessionCliente.getCliente().get();
    registrazioneForm.setNome(cliente.getNome());
    registrazioneForm.setCognome(cliente.getCognome());
    registrazioneForm.setCodiceFiscale(cliente.getCodiceFiscale());
    registrazioneForm.setEmail(cliente.getEmail());

    if (cliente.getClass() == Artigiano.class) {
      registrazioneForm.setArtigiano(true);
      registrazioneForm.setIban(((Artigiano) cliente).getIban());
    } else {
      registrazioneForm.setArtigiano(false);
    }

    return modificaProfiloView;
  }

  @PostMapping
  public String post(@ModelAttribute RegistrazioneForm registrazioneForm) {

    Optional<Cliente> optionalCliente = clienteDao.findByEmail(registrazioneForm.getEmail());
    Cliente cliente = optionalCliente.get();

    if (!cliente.getNome().equals(registrazioneForm.getNome())) {
      cliente.setNome(registrazioneForm.getNome());
    }

    if (!cliente.getCognome().equals(registrazioneForm.getCognome())) {
      cliente.setCognome(registrazioneForm.getCognome());
    }

    if (!cliente.getEmail().equals(registrazioneForm.getEmail())) {
      cliente.setEmail(registrazioneForm.getEmail());
    }

    if (!cliente.getCodiceFiscale().equals(registrazioneForm.getCodiceFiscale())) {
      cliente.setCodiceFiscale(registrazioneForm.getCodiceFiscale());
    }

    if (cliente.getClass() == Artigiano.class) {
      registrazioneForm.setArtigiano(true);
      ((Artigiano) cliente).setIban(registrazioneForm.getIban());
    } else {
      registrazioneForm.setArtigiano(false);
    }
    clienteDao.save(cliente);
    return modificaProfiloView;
  }
}