package it.unisa.justTraditions.applicationLogic;

import it.unisa.justTraditions.applicationLogic.util.Province;
import it.unisa.justTraditions.storage.gestioneAnnunciStorage.dao.AnnuncioDao;
import it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity.Annuncio;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.dao.ArtigianoDao;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.entity.Artigiano;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/TestDataBase")
public class TestDataBase {
  @Autowired
  private AnnuncioDao annuncioDao;

  @Autowired
  private ArtigianoDao artigianoDao;

  @GetMapping
  public ModelAndView test1() {
    Artigiano artigiano = new Artigiano();
    artigiano.setCodiceFiscale("12345678910");
    artigianoDao.findOne(Example.of(artigiano)).ifPresent(artigianoDao::delete);

    Artigiano arturo = new Artigiano(
        "Arturo@gmail.com",
        "1234",
        "Arturo",
        "Bido",
        "12345678910",
        "12345678"
    );
    Annuncio vinoBuono = new Annuncio(
        "VinoBuono",
        "Avellino",
        "IndirizzoCasa",
        "Faccio il vino buono",
        "Faccio il vino buono",
        8,
        new BigDecimal(3),
        Annuncio.Stato.PROPOSTO
    );

    //vinoBuono.setArtigiano(arturo);

    arturo.addAnnuncio(vinoBuono);
    artigianoDao.save(arturo);

    return new ModelAndView("test")
        .addObject("response", annuncioDao.findById(vinoBuono.getId()).orElseThrow())
        .addObject("province", Province.getProvince());
  }
}
