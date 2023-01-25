package it.unisa.justTraditions.applicationLogic.gestioneProfiliControl;

import it.unisa.justTraditions.storage.gestioneProfiliStorage.dao.ArtigianoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/VisualizzazioneProfiloArtigiano")
public class VisualizzazioneProfiloArtigianoController {
  private static final String visualizzazioneProfiloArtigianoView =
      "gestioneProfiliView/visualizzazioneProfiloArtigiano";
  @Autowired
  ArtigianoDao artigianoDao;

  @GetMapping
  public String get(@RequestParam Long id, Model model) {
    model.addAttribute("artigiano",
        artigianoDao.findById(id).orElseThrow(IllegalArgumentException::new));

    return visualizzazioneProfiloArtigianoView;
  }
}
