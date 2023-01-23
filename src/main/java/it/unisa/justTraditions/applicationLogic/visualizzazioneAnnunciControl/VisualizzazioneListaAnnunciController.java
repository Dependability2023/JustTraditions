package it.unisa.justTraditions.applicationLogic.visualizzazioneAnnunciControl;

import it.unisa.justTraditions.storage.gestioneAnnunciStorage.dao.AnnuncioDao;
import it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity.Annuncio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/visualizzazioneListaAnnunci")
public class VisualizzazioneListaAnnunciController {

  private static final String visualizzazioneListaAnnunciView =
      "visualizzazioneAnnunciView/visualizzazioneListaAnnunci";

  @Autowired
  AnnuncioDao annuncioDao;

  @GetMapping
  public ModelAndView get(@RequestParam(required = false) Annuncio.Stato stato) {
    Annuncio annuncio = new Annuncio();
    annuncio.setStato(stato);
    return new ModelAndView(visualizzazioneListaAnnunciView)
        .addObject("annunci", annuncioDao.findAll(Example.of(annuncio)));
  }
}