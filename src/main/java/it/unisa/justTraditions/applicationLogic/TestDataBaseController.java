package it.unisa.justTraditions.applicationLogic;

import it.unisa.justTraditions.applicationLogic.autenticazioneControl.util.PasswordEncryptor;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.dao.AmministratoreDao;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.entity.Amministratore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/TestDataBase")
public class TestDataBaseController {

  @Autowired
  private PasswordEncryptor passwordEncryptor;

  @Autowired
  private AmministratoreDao amministratoreDao;

  @GetMapping
  public void get() {
    Amministratore amministratore =
        new Amministratore("admin@live.it", passwordEncryptor.encryptPassword("Ciaoxd.1d"),
            "Pasquale", "De Rosa");

    amministratoreDao.save(amministratore);
  }
}
