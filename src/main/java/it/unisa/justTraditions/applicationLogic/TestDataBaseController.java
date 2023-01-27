package it.unisa.justTraditions.applicationLogic;

import it.unisa.justTraditions.applicationLogic.util.Province;
import it.unisa.justTraditions.storage.gestioneAnnunciStorage.dao.AnnuncioDao;
import it.unisa.justTraditions.applicationLogic.autenticazioneControl.util.PasswordEncryptor;
import it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity.Annuncio;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.dao.AmministratoreDao;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.dao.ArtigianoDao;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.entity.Amministratore;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.entity.Artigiano;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/TestDataBase")
public class TestDataBaseController {

  @Autowired
  private AnnuncioDao annuncioDao;

  @Autowired
  private PasswordEncryptor passwordEncryptor;

  @Autowired
  private AmministratoreDao admin;

  @GetMapping
  public @ResponseBody void get() {

    Amministratore amministratore = new Amministratore("admin@live.it",passwordEncryptor.encryptPassword("Ciaoxd.1d"),"Pasquale","De Rosa");

    admin.save(amministratore);
  }
}
