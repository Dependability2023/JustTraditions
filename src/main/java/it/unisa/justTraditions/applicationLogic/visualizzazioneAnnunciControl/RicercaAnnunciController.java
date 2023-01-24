package it.unisa.justTraditions.applicationLogic.visualizzazioneAnnunciControl;

import it.unisa.justTraditions.applicationLogic.util.Province;
import it.unisa.justTraditions.storage.gestioneAnnunciStorage.dao.AnnuncioDao;
import it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity.Annuncio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ricercaAnnunci")
public class RicercaAnnunciController {

  private static final String ricercaAnnunciView = "visualizzazioneAnnunciView/ricercaAnnunci";

  @Autowired
  private AnnuncioDao annuncioDao;

  @Autowired
  private Province province;

  @GetMapping
  public String get(@RequestParam(defaultValue = "", required = false) String nomeAttivita,
                    @RequestParam(defaultValue = "", required = false) String provincia,
                    @RequestParam(defaultValue = "0", required = false) Integer pagina,
                    Model model) {
    if (!nomeAttivita.isBlank() && nomeAttivita.length() > 40) {
      throw new IllegalArgumentException();
    }
    if (!provincia.isBlank() && !province.getProvince().contains(provincia)) {
      throw new IllegalArgumentException();
    }

    Annuncio annuncio = new Annuncio();
    annuncio.setNomeAttivita(nomeAttivita);
    annuncio.setProvinciaAttivita(provincia);
    annuncio.setStato(Annuncio.Stato.APPROVATO);

    Example<Annuncio> annuncioExample = Example.of(
        annuncio,
        ExampleMatcher.matching()
            .withIgnoreCase()
            .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
    );

    Page<Annuncio> annuncioPage = annuncioDao.findAll(
        annuncioExample,
        PageRequest.of(pagina, 20, Sort.by(Sort.Direction.ASC, "nomeAttivita"))
    );

    int totalPages = annuncioPage.getTotalPages();
    if (totalPages <= pagina) {
      throw new IllegalArgumentException();
    }

    model.addAttribute("annunci", annuncioPage.getContent());
    model.addAttribute("pagina", pagina);
    model.addAttribute("nomeAttivita", nomeAttivita);
    model.addAttribute("provincia", provincia);
    model.addAttribute("pagineTotali", totalPages);

    return ricercaAnnunciView;
  }
}