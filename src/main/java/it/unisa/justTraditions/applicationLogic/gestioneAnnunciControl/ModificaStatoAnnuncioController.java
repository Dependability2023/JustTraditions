package it.unisa.justTraditions.applicationLogic.gestioneAnnunciControl;

import it.unisa.justTraditions.applicationLogic.autenticazioneControl.util.SessionAmministratore;
import it.unisa.justTraditions.applicationLogic.gestioneAnnunciControl.form.ModificaStatoAnnuncioForm;
import it.unisa.justTraditions.storage.gestioneAnnunciStorage.dao.AnnuncioDao;
import it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity.Annuncio;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.dao.AmministratoreDao;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.entity.Amministratore;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/modificaStatoAnnuncio")
public class ModificaStatoAnnuncioController {

  private static final String modificaStatoAnnuncioView =
      "gestioneAnnunciView/modificaStatoAnnuncio";

  private static final String modificaAnnuncioSuccessView =
      "gestioneAnnunciView/modificaAnnuncioSuccess";

  @Autowired
  private AnnuncioDao annuncioDao;

  @Autowired
  private AmministratoreDao amministratoreDao;

  @Autowired
  private SessionAmministratore sessionAmministratore;

  @GetMapping
  public ModelAndView get(@RequestParam Long idAnnuncio) {
    return new ModelAndView(modificaStatoAnnuncioView)
        .addObject("annuncio", annuncioDao.findById(idAnnuncio).get());
  }

  @PostMapping
  public String post(@ModelAttribute @Valid ModificaStatoAnnuncioForm modificaStatoAnnuncioForm,
                     BindingResult bindingResult, Model model) {
    Annuncio annuncio = annuncioDao.findById(modificaStatoAnnuncioForm.getIdAnnuncio()).get();

    if (bindingResult.hasErrors()) {
      model.addAttribute("annuncio", annuncio);
      return modificaStatoAnnuncioView;
    }

    annuncio.setStato(modificaStatoAnnuncioForm.getNuovoStato());

    String motivoDelRifiuto = null;
    if (modificaStatoAnnuncioForm.getNuovoStato() == Annuncio.Stato.RIFIUTATO) {
      motivoDelRifiuto = modificaStatoAnnuncioForm.getMotivoDelRifiuto();
    }
    annuncio.setMotivoDelRifiuto(motivoDelRifiuto);

    if (modificaStatoAnnuncioForm.getNuovoStato() == Annuncio.Stato.APPROVATO) {
      Amministratore amministratore = sessionAmministratore.getAmministratore().get();
      amministratore.addAnnuncioApprovato(annuncio);
      amministratoreDao.save(amministratore);
    } else if (modificaStatoAnnuncioForm.getNuovoStato() == Annuncio.Stato.IN_REVISIONE) {
      Amministratore amministratore = annuncio.getAmministratore();
      if (amministratore != null) {
        amministratore.removeAnnuncioApprovato(annuncio);
        amministratoreDao.save(amministratore);
      }
    }

    annuncioDao.save(annuncio);

    model.addAttribute("isAmministratore", true);
    return modificaAnnuncioSuccessView;
  }
}
