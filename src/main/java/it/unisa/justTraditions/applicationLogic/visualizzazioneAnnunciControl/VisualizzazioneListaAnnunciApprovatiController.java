package it.unisa.justTraditions.applicationLogic.visualizzazioneAnnunciControl;

import it.unisa.justTraditions.storage.gestioneAnnunciStorage.dao.AnnuncioDao;
import it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity.Annuncio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/listaannunci")
public class VisualizzazioneListaAnnunciApprovatiController {

  @Autowired
  private AnnuncioDao annuncioDao;


  @GetMapping
  public ModelAndView get() {
    Annuncio annuncio = new Annuncio();
    annuncio.setStato(Annuncio.Stato.APPROVATO);
    List<Annuncio> annunci = annuncioDao.findAll(Example.of(annuncio));

    return new ModelAndView("visualizzazioneAnnunciView/visualizzazioneListaAnnunciApprovati")
        .addObject("annunci", annunci);
  }
}

