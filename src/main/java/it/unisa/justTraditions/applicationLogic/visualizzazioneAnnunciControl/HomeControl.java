package it.unisa.justTraditions.applicationLogic.visualizzazioneAnnunciControl;

import it.unisa.justTraditions.storage.gestioneAnnunciStorage.dao.AnnuncioDao;
import it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity.Annuncio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/Home")
public class HomeControl {
  @Autowired
  AnnuncioDao annuncioDao;

  @GetMapping
  public ModelAndView home() {
    Page<Annuncio> annuncioPage = annuncioDao.findAll(PageRequest.of(0, 5));
    List<Annuncio> annuncioListHome = annuncioPage.getContent();

    return new ModelAndView("homepage")
        .addObject("Annunci", annuncioListHome);
  }
}

