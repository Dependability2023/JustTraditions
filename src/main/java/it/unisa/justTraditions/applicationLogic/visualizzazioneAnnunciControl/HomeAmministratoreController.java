package it.unisa.justTraditions.applicationLogic.visualizzazioneAnnunciControl;

import it.unisa.justTraditions.storage.gestioneAnnunciStorage.dao.AnnuncioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/homeAmministratore")
public class HomeAmministratoreController {

  private static final String homeAmministratoreView =
      "visualizzazioneAnnunciView/homeAmministratore";

  @Autowired
  private AnnuncioDao annuncioDao;

  @GetMapping
  public String get(Model model) {
    model.addAttribute("annunci", annuncioDao.findAll(PageRequest.of(
        0,
        8,
        Sort.by(Sort.Direction.DESC, "id")
    )).getContent());


    return homeAmministratoreView;
  }
}

