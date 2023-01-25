package it.unisa.justTraditions.applicationLogic.prenotazioniControl;

import it.unisa.justTraditions.applicationLogic.autenticazioneControl.util.SessionCliente;
import it.unisa.justTraditions.storage.gestioneAnnunciStorage.dao.AnnuncioDao;
import it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity.Annuncio;
import it.unisa.justTraditions.storage.prenotazioniStorage.dao.PrenotazioneDao;
import it.unisa.justTraditions.storage.prenotazioniStorage.entity.Prenotazione;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/visualizzazionePrenotazioniAnnuncio")
public class VisualizzazionePrenotazioniAnnuncioController {

  private static final String visualizzazionePrenotazioniAnnuncioView =
      "prenotazioniView/visualizzazionePrenotazioniAnnuncio";

  @Autowired
  private SessionCliente sessionCliente;

  @Autowired
  private PrenotazioneDao prenotazioneDao;

  @Autowired
  private AnnuncioDao annuncioDao;

  @GetMapping
  public ModelAndView get(@RequestParam Long idAnnuncio) {
    return new ModelAndView(visualizzazionePrenotazioniAnnuncioView)
        .addObject("idAnnuncio", idAnnuncio);
  }

  @PostMapping
  public String post(@RequestParam Long idAnnuncio,
                     @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                     LocalDate dataVisita,
                     @RequestParam(defaultValue = "0", required = false) Integer pagina,
                     Model model) {
    Annuncio annuncio = annuncioDao.findById(idAnnuncio).orElseThrow(IllegalArgumentException::new);
    if (!annuncio.getArtigiano().equals(sessionCliente.getCliente().get())) {
      throw new IllegalArgumentException();
    }
    Page<Prenotazione> prenotazionePage =
        prenotazioneDao.findByVisitaAnnuncioAndDataVisita(annuncio, dataVisita,
            PageRequest.of(pagina, 20, Sort.by(
                Sort.Direction.DESC, "dataVisita")));

    int totalPages = prenotazionePage.getTotalPages();
    if (totalPages <= pagina) {
      throw new IllegalArgumentException();
    }


    model.addAttribute("prenotazioni", prenotazionePage.getContent());
    model.addAttribute("pagina", pagina);
    model.addAttribute("pagineTotali", totalPages);
    model.addAttribute("idAnnuncio", idAnnuncio);
    model.addAttribute("dataVisita", dataVisita);

    return visualizzazionePrenotazioniAnnuncioView;
  }
}

