package it.unisa.justTraditions.applicationLogic.autenticazioneControl.util;

import it.unisa.justTraditions.storage.gestioneProfiliStorage.entity.Cliente;
import jakarta.servlet.http.HttpSession;
import java.util.Optional;

public abstract class AutenticazioneCliente {

  public static void setCliente(HttpSession session, Cliente cliente) {

    session.setAttribute("cliente", cliente);
  }

  public static Optional<Cliente> getCliente(HttpSession session) {
    return Optional.ofNullable((Cliente) session.getAttribute("cliente"));
  }
}
