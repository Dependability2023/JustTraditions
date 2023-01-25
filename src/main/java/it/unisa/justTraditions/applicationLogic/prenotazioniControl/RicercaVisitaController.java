package it.unisa.justTraditions.applicationLogic.prenotazioniControl;

import it.unisa.justTraditions.storage.gestioneAnnunciStorage.dao.VisitaDao;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ricercaVisita")
public class RicercaVisitaController {
  @Autowired
  VisitaDao visitaDao;

  @PostMapping
  private void post(@RequestParam Long idAnnuncio,
                    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                    LocalDate dataVisita) {


  }
}
