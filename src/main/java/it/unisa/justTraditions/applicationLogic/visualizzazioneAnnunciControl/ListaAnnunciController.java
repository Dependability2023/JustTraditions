package it.unisa.justTraditions.applicationLogic.visualizzazioneAnnunciControl;

import it.unisa.justTraditions.storage.gestioneAnnunciStorage.dao.AnnuncioDao;
import it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity.Annuncio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/listaAnnunci")
public class ListaAnnunciController {

  @Autowired
  private AnnuncioDao annuncioDao;

  @GetMapping
  public ModelAndView get() {
    List<Annuncio> annunci = annuncioDao.findAll();

    return new ModelAndView("visualizzazioneAnnunciView/listaAnnunci")
        .addObject("annunci", annunci);
  }
}

