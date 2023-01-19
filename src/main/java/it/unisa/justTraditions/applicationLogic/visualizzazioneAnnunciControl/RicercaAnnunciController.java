package it.unisa.justTraditions.applicationLogic.visualizzazioneAnnunciControl;

import it.unisa.justTraditions.storage.gestioneAnnunciStorage.dao.AnnuncioDao;
import it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity.Annuncio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ricerca")
public class RicercaAnnunciController {
  private static final String visualezzazioneListaAnnunciView =
      "/visualizzazioneAnnunciView/visualizzazioneListaAnnunciApprovati";
  @Autowired
  private AnnuncioDao annuncioDao;

  @GetMapping
  public String get(String ricerca, String provincia, Model model) {
    System.out.println(ricerca + provincia);


    Annuncio annuncio = new Annuncio();
    annuncio.setNomeAttivita(ricerca.isEmpty() ? null : ricerca);
    annuncio.setProvinciaAttivita(provincia.isEmpty() ? null : provincia);

    model.addAttribute("annunci", annuncioDao.findAll(Example.of(annuncio)));
    System.out.println(annuncioDao.findAll(Example.of(annuncio)));


    return visualezzazioneListaAnnunciView;
  }


}
