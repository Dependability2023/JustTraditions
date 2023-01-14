package it.unisa.justTraditions.applicationLogic.autenticazioneControl.util;

import it.unisa.justTraditions.storage.gestioneProfiliStorage.entity.Cliente;
import java.util.Optional;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class SessionCliente {

  private Cliente cliente;

  public Optional<Cliente> getCliente() {
    return Optional.ofNullable(cliente);
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }
}
