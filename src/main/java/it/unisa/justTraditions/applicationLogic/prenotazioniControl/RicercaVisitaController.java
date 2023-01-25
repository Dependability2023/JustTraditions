package it.unisa.justTraditions.applicationLogic.prenotazioniControl;

import it.unisa.justTraditions.applicationLogic.prenotazioniControl.json.VisitaResponse;
import it.unisa.justTraditions.storage.gestioneAnnunciStorage.dao.AnnuncioDao;
import it.unisa.justTraditions.storage.gestioneAnnunciStorage.dao.VisitaDao;
import it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity.Annuncio;
import it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity.Visita;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ricercaVisita")
public class RicercaVisitaController {

  @Autowired
  private VisitaDao visitaDao;

  @Autowired
  private AnnuncioDao annuncioDao;

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  private List<VisitaResponse> post(@RequestParam Long idAnnuncio,
                                    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                    LocalDate dataVisita) {
    Optional<Annuncio> optionalAnnuncio = annuncioDao.findById(idAnnuncio);
    if (optionalAnnuncio.isEmpty()) {
      return List.of();
    }
    Annuncio annuncio = optionalAnnuncio.get();

    Visita visita = new Visita();
    visita.setAnnuncio(annuncio);
    visita.setGiorno(dataVisita.getDayOfWeek());
    visita.setValidita(true);

    return visitaDao.findAll(Example.of(visita)).stream()
        .map(v -> new VisitaResponse(v.getId(), v.getOrarioInizio(), v.getOrarioFine()))
        .toList();
  }
}
