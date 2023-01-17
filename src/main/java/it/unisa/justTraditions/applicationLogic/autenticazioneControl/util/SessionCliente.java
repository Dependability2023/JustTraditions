package it.unisa.justTraditions.applicationLogic.autenticazioneControl.util;

import it.unisa.justTraditions.storage.gestioneProfiliStorage.dao.ClienteDao;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.entity.Cliente;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class SessionCliente {
  @Autowired
  private ClienteDao clienteDao;
  private Long idCliente;

  public Optional<Cliente> getCliente() {
    if (idCliente != null) {
      return clienteDao.findById(idCliente);
    }
    return Optional.empty();


  }

  public void setCliente(Cliente cliente) {
    if (cliente == null) {
      this.idCliente = null;
    } else {
      this.idCliente = cliente.getId();
    }

  }
}
