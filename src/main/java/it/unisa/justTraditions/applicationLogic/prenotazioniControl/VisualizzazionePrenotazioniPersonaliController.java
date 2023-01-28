package it.unisa.justTraditions.applicationLogic.prenotazioniControl;


import it.unisa.justTraditions.applicationLogic.autenticazioneControl.util.SessionCliente;
import it.unisa.justTraditions.storage.prenotazioniStorage.dao.PrenotazioneDao;
import it.unisa.justTraditions.storage.prenotazioniStorage.entity.Prenotazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/visualizzazionePrenotazioniPersonali")
public class VisualizzazionePrenotazioniPersonaliController {

  private static final String visualizzazionePrenotazioniPersonaliView =
      "prenotazioniView/visualizzazionePrenotazioniPersonali";

  @Autowired
  private SessionCliente sessionCliente;

  @Autowired
  private PrenotazioneDao prenotazioneDao;

  @GetMapping
  public ModelAndView get(@RequestParam(defaultValue = "0", required = false) Integer pagina) {
    Page<Prenotazione> prenotazionePage = prenotazioneDao.findByCliente(
        sessionCliente.getCliente().get(),
        PageRequest.of(pagina, 20, Sort.by(Sort.Direction.DESC, "dataVisita"))
    );

    int totalPages = prenotazionePage.getTotalPages();
    if (totalPages < pagina) {
      throw new IllegalArgumentException();
    }

    return new ModelAndView(visualizzazionePrenotazioniPersonaliView)
        .addObject("prenotazioni", prenotazionePage.getContent())
        .addObject("pagina", pagina)
        .addObject("pagineTotali", totalPages);
  }
}
