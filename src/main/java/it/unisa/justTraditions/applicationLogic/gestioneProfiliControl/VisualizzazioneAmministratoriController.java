package it.unisa.justTraditions.applicationLogic.gestioneProfiliControl;

import it.unisa.justTraditions.storage.gestioneProfiliStorage.dao.AmministratoreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/visualizzazioneAmministratori")
public class VisualizzazioneAmministratoriController {

  private static final String visualizzazioneAmministratoriView =
      "gestioneProfiliView/visualizzazioneAmministratori";

  @Autowired
  private AmministratoreDao amministratoreDao;

  @GetMapping
  public ModelAndView get() {
    return new ModelAndView(visualizzazioneAmministratoriView)
        .addObject("Amministratori", amministratoreDao.findAll());
  }
}
