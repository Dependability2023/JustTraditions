package it.unisa.justTraditions.applicationLogic.visualizzazioneAnnunciControl;

import it.unisa.justTraditions.applicationLogic.util.Province;
import it.unisa.justTraditions.storage.gestioneAnnunciStorage.dao.AnnuncioDao;
import it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity.Annuncio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ricercaAnnunci")
public class RicercaAnnunciController {

  private static final String ricercaAnnunciView =
      "visualizzazioneAnnunciView/ricercaAnnunci";

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


    List<Annuncio> annunci =
        annuncioDao.findByNomeAttivitaContainsIgnoreCaseAndProvinciaAttivitaContains(
            nomeAttivita,
            provincia,
                PageRequest.of(pagina, 4, Sort.by(Sort.Direction.ASC, "nomeAttivita"))
        );

if(annunci.isEmpty()){
    pagina--;
     annunci =
            annuncioDao.findByNomeAttivitaContainsIgnoreCaseAndProvinciaAttivitaContains(
                    nomeAttivita,
                    provincia,
                    PageRequest.of(pagina, 4, Sort.by(Sort.Direction.ASC, "nomeAttivita"))
            );
}
    model.addAttribute("annunci", annunci);
   model.addAttribute("ricercaPagina",pagina);
    model.addAttribute("ricercaNomeAttivita",nomeAttivita);
    model.addAttribute("ricercaProvincia",provincia);

    return ricercaAnnunciView;
  }
}
