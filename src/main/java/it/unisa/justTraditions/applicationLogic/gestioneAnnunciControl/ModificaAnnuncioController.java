package it.unisa.justTraditions.applicationLogic.gestioneAnnunciControl;

import it.unisa.justTraditions.applicationLogic.autenticazioneControl.util.SessionCliente;
import it.unisa.justTraditions.applicationLogic.gestioneAnnunciControl.form.AnnuncioForm;
import it.unisa.justTraditions.applicationLogic.gestioneAnnunciControl.form.VisitaForm;
import it.unisa.justTraditions.storage.gestioneAnnunciStorage.dao.AnnuncioDao;
import it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity.Annuncio;
import it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity.Foto;
import it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity.Visita;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/modificaAnnuncio")
public class ModificaAnnuncioController {

  private static final String modificaAnnuncioView = "gestioneAnnunciView/modificaAnnuncio";

  @Autowired
  private AnnuncioDao annuncioDao;

  @Autowired
  private SessionCliente sessionCliente;

  @GetMapping
  public String get(@RequestParam Long id, Model model) {
    Optional<Annuncio> optionalAnnuncio = annuncioDao.findById(id);
    if (optionalAnnuncio.isEmpty()) {
      throw new IllegalArgumentException();
    }

    Annuncio annuncio = optionalAnnuncio.get();
    if (!annuncio.getArtigiano().equals(sessionCliente.getCliente().get())) {
      throw new IllegalArgumentException();
    }

    AnnuncioForm annuncioForm = new AnnuncioForm();
    annuncioForm.setNomeAttivita(annuncio.getNomeAttivita());
    annuncioForm.setProvinciaAttivita(annuncio.getProvinciaAttivita());
    annuncioForm.setIndirizzoAttivita(annuncio.getIndirizzoAttivita());
    annuncioForm.setDescrizione(annuncio.getDescrizione());
    annuncioForm.setServiziOfferti(annuncio.getServiziOfferti());
    annuncioForm.setNumMaxPersonePerVisita(annuncio.getNumMaxPersonePerVisita());
    annuncioForm.setPrezzoVisita(annuncio.getPrezzoVisita());

    List<Long> idFoto = annuncio.getFoto().stream()
        .map(Foto::getId)
        .toList();
    model.addAttribute("idFoto", idFoto);

    List<VisitaForm> visiteForm = annuncio.getVisite().stream()
        .filter(Visita::getValidita)
        .map(v -> new VisitaForm(v.getId(), v.getGiorno(), v.getOrarioInizio(), v.getOrarioFine()))
        .toList();
    annuncioForm.setVisite(visiteForm);

    model.addAttribute("annuncioForm", annuncioForm);

    return modificaAnnuncioView;
  }
}

