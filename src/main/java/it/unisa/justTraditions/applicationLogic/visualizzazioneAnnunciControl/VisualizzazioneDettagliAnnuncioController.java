package it.unisa.justTraditions.applicationLogic.visualizzazioneAnnunciControl;

import it.unisa.justTraditions.storage.gestioneAnnunciStorage.dao.AnnuncioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/visualizzazioneDettagliAnnuncio")
public class VisualizzazioneDettagliAnnuncioController {

  private static final String visualizzazioneSchedaAnnuncioView =
      "visualizzazioneAnnunciView/visualizzazioneDettagliAnnuncio";

  @Autowired
  private AnnuncioDao annuncioDao;

  @GetMapping
  public ModelAndView get(@RequestParam Long id) {
    return new ModelAndView(visualizzazioneSchedaAnnuncioView)
        .addObject(annuncioDao.findById(id).get());
  }
}

