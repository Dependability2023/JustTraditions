package it.unisa.justTraditions.applicationLogic.autenticazioneControl.util;

import it.unisa.justTraditions.storage.gestioneProfiliStorage.dao.AmministratoreDao;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.entity.Amministratore;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class SessionAmministratore {

  private Long idAmministratore;

  @Autowired
  private AmministratoreDao amministratoreDao;

  public Optional<Amministratore> getAmministratore() {
    if (idAmministratore != null) {
      return amministratoreDao.findById(idAmministratore);
    }
    return Optional.empty();
  }

  public void setAmministratore(Amministratore amministratore) {
    if (amministratore == null) {
      this.idAmministratore = null;
    } else {
      this.idAmministratore = amministratore.getId();
    }
  }
}