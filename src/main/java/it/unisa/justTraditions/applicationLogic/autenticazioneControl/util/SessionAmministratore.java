package it.unisa.justTraditions.applicationLogic.autenticazioneControl.util;

import it.unisa.justTraditions.storage.gestioneProfiliStorage.entity.Amministratore;
import java.util.Optional;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class SessionAmministratore {
  private Amministratore amministratore;


  public Optional<Amministratore> getAmministratore() {
    return Optional.ofNullable(amministratore);
  }

  public void setAmministratore(Amministratore amministratore) {
    this.amministratore = amministratore;
  }
}