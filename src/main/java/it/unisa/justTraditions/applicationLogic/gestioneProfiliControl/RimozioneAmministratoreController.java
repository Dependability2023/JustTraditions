package it.unisa.justTraditions.applicationLogic.gestioneProfiliControl;

import it.unisa.justTraditions.storage.gestioneProfiliStorage.dao.AmministratoreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/RimozioneAmministratore")
public class RimozioneAmministratoreController {
  private static final String visualizzazioneAmministratori =
      "redirect:/visualizzazioneAmministratori";
  @Autowired
  AmministratoreDao amministratoreDao;

  @GetMapping
  public String get(@RequestParam() Long id) {

    amministratoreDao.delete(amministratoreDao.findById(id).orElseThrow());

    return visualizzazioneAmministratori;
  }
}