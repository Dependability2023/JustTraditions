package it.unisa.justTraditions.applicationLogic.prenotazioniControl;

import it.unisa.justTraditions.applicationLogic.autenticazioneControl.util.SessionCliente;
import it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity.Annuncio;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.entity.Artigiano;
import it.unisa.justTraditions.storage.prenotazioniStorage.dao.PrenotazioneDao;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/visualizzazionePrenotazioniAnnuncio")
public class VisualizzazionePrenotazioniAnnuncioController {
  @Autowired
  private SessionCliente sessionCliente;
  @Autowired
  private PrenotazioneDao prenotazioneDao;
  private static final String visualizzazionePrenotazioniAnnuncioView =
      "prenotazioniView/visualizzazionePrenotazioniAnnuncio";

  @GetMapping
  public String get(Model model) {
    Artigiano artigiano = (Artigiano) sessionCliente.getCliente().get();
    List<Annuncio> annunci = artigiano.getAnnunci();

    model.addAttribute("annunci", annunci);
    return visualizzazionePrenotazioniAnnuncioView;
  }

  @PostMapping
  public String post(@RequestParam() Long id, @RequestParam() LocalDate dataVisita, Model model) {

    Artigiano artigiano = (Artigiano) sessionCliente.getCliente().get();
    List<Annuncio> annunci = artigiano.getAnnunci();
    Optional<Annuncio> optionalAnnuncio =
        annunci.stream().filter(annuncio -> (annuncio.getId() == id)).findFirst();
    if (optionalAnnuncio.isEmpty()) {
      throw new IllegalArgumentException();
    }
    model.addAttribute("prenotazioni",
        prenotazioneDao.finByVisitaAnnuncioAndDataVisita(optionalAnnuncio.get(), dataVisita));
    return visualizzazionePrenotazioniAnnuncioView;

  }
}

