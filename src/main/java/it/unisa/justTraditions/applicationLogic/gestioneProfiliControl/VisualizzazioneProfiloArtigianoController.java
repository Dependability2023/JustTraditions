package it.unisa.justTraditions.applicationLogic.gestioneProfiliControl;

import it.unisa.justTraditions.storage.gestioneProfiliStorage.dao.ArtigianoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/visualizzazioneProfiloArtigiano")
public class VisualizzazioneProfiloArtigianoController {

  private static final String visualizzazioneProfiloArtigianoView =
      "gestioneProfiliView/visualizzazioneProfiloArtigiano";

  @Autowired
  private ArtigianoDao artigianoDao;

  @GetMapping
  public ModelAndView get(@RequestParam Long id) {
    return new ModelAndView(visualizzazioneProfiloArtigianoView)
        .addObject(artigianoDao.findById(id).orElseThrow(IllegalArgumentException::new));
  }
}
