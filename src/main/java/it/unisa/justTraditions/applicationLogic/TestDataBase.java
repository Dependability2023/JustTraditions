package it.unisa.justTraditions.applicationLogic;

import it.unisa.justTraditions.storage.gestioneAnnunciStorage.dao.AnnuncioDao;
import it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity.Annuncio;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.dao.ArtigianoDao;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.entity.Artigiano;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(path = "/TestDataBase")
@Controller
public class TestDataBase {
  @Autowired
  private AnnuncioDao annuncioDao;
  @Autowired
  private ArtigianoDao artigianoDao;

  @GetMapping
  public @ResponseBody String Test1() {

    Artigiano arturo =
        new Artigiano("Arturo@gmail.com", "1234", "Arturo", "Bido", "12345678910", "12345678");

    Artigiano mauro =
        new Artigiano("mauro@gmail.com", "1234", "mauro", "Bido", "12344578910", "12345654");
    Annuncio vinoBuono =
        new Annuncio("VinoBuono", "Avellino", "IndirizzoCasa", "Faccio il vino buono",
            "Faccio il vino buono", 8, new BigDecimal(3));
  

    arturo.addAnnuncio(vinoBuono);
    artigianoDao.save(arturo);
    return annuncioDao.findById(vinoBuono.getId()).orElseThrow().toString();

  }

}
