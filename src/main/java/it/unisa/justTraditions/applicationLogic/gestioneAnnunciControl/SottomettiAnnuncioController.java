package it.unisa.justTraditions.applicationLogic.gestioneAnnunciControl;

import it.unisa.justTraditions.applicationLogic.autenticazioneControl.util.SessionCliente;
import it.unisa.justTraditions.applicationLogic.gestioneAnnunciControl.form.AnnuncioForm;
import it.unisa.justTraditions.applicationLogic.gestioneAnnunciControl.form.VisitaForm;
import it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity.Annuncio;
import it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity.Foto;
import it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity.Visita;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.dao.ArtigianoDao;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.entity.Artigiano;
import jakarta.validation.Valid;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sottomettiannuncio")
public class SottomettiAnnuncioController {
  private final static String SottomissioneView = "gestioneAnnunciView/sottomissioneAnnuncio";
  @Autowired
  SessionCliente sessionCliente;
  @Autowired
  ArtigianoDao artigianoDao;

  @GetMapping
  public ModelAndView get() {
    return new ModelAndView(SottomissioneView)
        .addObject("annuncioForm", new AnnuncioForm());
  }

  @PostMapping
  public String post(@ModelAttribute @Valid AnnuncioForm annuncioForm,
                     BindingResult bindingResult, Model model) {
    System.out.println("registrzione: " + annuncioForm.toString() + annuncioForm.getFoto().size());

    Annuncio annuncio = new Annuncio(
        annuncioForm.getNomeAttivita(),
        annuncioForm.getProvinciaAttivita(),
        annuncioForm.getIndirizzoAttivita(),
        annuncioForm.getDescrizione(),
        annuncioForm.getServiziOfferti(),
        annuncioForm.getNumMaxPersonePerVisita(),
        annuncioForm.getPrezzoVisita(),
        Annuncio.Stato.PROPOSTO
    );
    for (MultipartFile file : annuncioForm.getFoto()) {
      try {
        annuncio.addFoto(new Foto(file.getBytes()));
      } catch (IOException e) {
        model.addAttribute("erroreFile", true);
        return SottomissioneView;
      }
    }
    for (VisitaForm visitaForm : annuncioForm.getVisite()) {

      annuncio.addVisita(new Visita(visitaForm.getGiorno(), visitaForm.getOrarioInizio(),
          visitaForm.getOrarioFine(), true));
      return SottomissioneView;

    }

    Artigiano artigiano = (Artigiano) sessionCliente.getCliente().get();
    artigiano.addAnnuncio(annuncio);
    artigianoDao.save(artigiano);

    return "redirect:/";
  }
}

