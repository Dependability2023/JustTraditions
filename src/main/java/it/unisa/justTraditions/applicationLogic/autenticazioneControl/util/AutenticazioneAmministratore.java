package it.unisa.justTraditions.applicationLogic.autenticazioneControl.util;

import it.unisa.justTraditions.storage.gestioneProfiliStorage.entity.Amministratore;
import jakarta.servlet.http.HttpSession;
import java.util.Optional;

public class AutenticazioneAmministratore {
  public static void setAmministratore(HttpSession session, Amministratore amministratore) {

    session.setAttribute("Amministratore", amministratore);
  }

  public static Optional<Amministratore> getAmministrator(HttpSession session) {
    return Optional.ofNullable(
        (Amministratore) session.getAttribute("amministratore"));
  }
}
