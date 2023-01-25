package it.unisa.justTraditions.applicationLogic.visualizzazioneAnnunciControl;

import it.unisa.justTraditions.storage.gestioneAnnunciStorage.dao.AnnuncioDao;
import it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity.Annuncio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
  public ModelAndView get(@RequestParam(required = false) Annuncio.Stato stato,
                          @RequestParam(defaultValue = "0", required = false) Integer pagina,
                          Model model) {
    Annuncio annuncio = new Annuncio();
    annuncio.setStato(stato);

    Page<Annuncio> annuncioPage = annuncioDao.findAll(
        Example.of(annuncio),
        PageRequest.of(pagina, 20, Sort.by(Sort.Direction.DESC, "id"))
    );

    int totalPages = annuncioPage.getTotalPages();
    if (totalPages <= pagina) {
      throw new IllegalArgumentException();
    }

    model.addAttribute("annunci", annuncioPage.getContent());
    model.addAttribute("pagina", pagina);
    model.addAttribute("pagineTotali", totalPages);

    return new ModelAndView(visualizzazioneListaAnnunciView);
  }
}