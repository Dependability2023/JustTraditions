package it.unisa.justTraditions.applicationLogic.visualizzazioneAnnunciControl;

import it.unisa.justTraditions.storage.gestioneAnnunciStorage.dao.AnnuncioDao;
import it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity.Annuncio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/visualizzazioneDettagliAnnuncio")
public class VisualizzazioneDettagliAnnuncioController {

  private static final String visualizzazioneDettagliAnnuncioView =
      "visualizzazioneAnnunciView/visualizzazioneDettagliAnnuncio";

  @Autowired
  private AnnuncioDao annuncioDao;

  @GetMapping
  public ModelAndView get(@RequestParam Long id) {
    Annuncio annuncio = annuncioDao.findById(id).orElseThrow(IllegalArgumentException::new);
    if (!annuncio.getStato().equals(Annuncio.Stato.APPROVATO)) {
      throw new IllegalArgumentException();
    }

    return new ModelAndView(visualizzazioneDettagliAnnuncioView)
        .addObject("totalFoto", annuncio.getFoto().size())
        .addObject("annuncio", annuncio);
  }
}

