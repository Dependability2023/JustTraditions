package it.unisa.justTraditions.applicationLogic.visualizzazioneAnnunciControl;

import it.unisa.justTraditions.storage.gestioneAnnunciStorage.dao.AnnuncioDao;
import it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity.Annuncio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

  private static final String homeView = "visualizzazioneAnnunciView/home";

  @Autowired
  private AnnuncioDao annuncioDao;

  @GetMapping
  public ModelAndView get() {
    Annuncio annuncio = new Annuncio();
    annuncio.setStato(Annuncio.Stato.APPROVATO);

    Page<Annuncio> annunci = annuncioDao.findAll(
            Example.of(annuncio),
            PageRequest.of(0, 8, Sort.by(Sort.Direction.DESC, "id"))
    );



    return new ModelAndView(homeView)
        .addObject("annunci", annunci);
  }
}

