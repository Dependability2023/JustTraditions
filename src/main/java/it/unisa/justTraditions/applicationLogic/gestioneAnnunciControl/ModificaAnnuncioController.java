package it.unisa.justTraditions.applicationLogic.gestioneAnnunciControl;

import it.unisa.justTraditions.applicationLogic.autenticazioneControl.util.SessionCliente;
import it.unisa.justTraditions.applicationLogic.gestioneAnnunciControl.form.AnnuncioForm;
import it.unisa.justTraditions.applicationLogic.gestioneAnnunciControl.form.VisitaForm;
import it.unisa.justTraditions.storage.gestioneAnnunciStorage.dao.AnnuncioDao;
import it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity.Annuncio;
import it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity.Foto;
import it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity.Visita;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/modificaAnnuncio")
public class ModificaAnnuncioController {

  private static final String modificaAnnuncioView = "gestioneAnnunciView/modificaAnnuncio";
  private static final String sottomissioneAnnuncioSuccessView =
      "gestioneAnnunciView/sottomissioneAnnuncioSuccess";

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

  @PostMapping
  public String post(@ModelAttribute @Valid AnnuncioForm annuncioForm,
                     @RequestParam List<Long> idFoto) {
    if (annuncioForm.getIdAnnuncio() == null) {
      throw new IllegalArgumentException();
    }

    Optional<Annuncio> optionalAnnuncio = annuncioDao.findById(annuncioForm.getIdAnnuncio());
    if (optionalAnnuncio.isEmpty()) {
      throw new IllegalArgumentException();
    }

    Annuncio annuncio = optionalAnnuncio.get();
    if (!annuncio.getArtigiano().equals(sessionCliente.getCliente().get())) {
      throw new IllegalArgumentException();
    }

    boolean modificaInformazioniAttivita;

    if (!annuncio.getNomeAttivita().equals(annuncioForm.getNomeAttivita())) {
      annuncio.setNomeAttivita(annuncioForm.getNomeAttivita());
      modificaInformazioniAttivita = true;
    }

    if (!annuncio.getProvinciaAttivita().equals(annuncioForm.getProvinciaAttivita())) {
      annuncio.setProvinciaAttivita(annuncioForm.getProvinciaAttivita());
      modificaInformazioniAttivita = true;
    }

    if (!annuncio.getIndirizzoAttivita().equals(annuncioForm.getIndirizzoAttivita())) {
      annuncio.setIndirizzoAttivita(annuncioForm.getIndirizzoAttivita());
      modificaInformazioniAttivita = true;
    }

    if (!annuncio.getDescrizione().equals(annuncioForm.getDescrizione())) {
      annuncio.setDescrizione(annuncioForm.getDescrizione());
      modificaInformazioniAttivita = true;
    }

    if (!annuncio.getServiziOfferti().equals(annuncioForm.getServiziOfferti())) {
      annuncio.setServiziOfferti(annuncioForm.getServiziOfferti());
      modificaInformazioniAttivita = true;
    }

    for (Foto foto : annuncio.getFoto()) {
      if (!idFoto.contains(foto.getId())) {
        annuncio.removeFoto(foto);
      }
    }

    return sottomissioneAnnuncioSuccessView;
  }
}

