package it.unisa.justTraditions.applicationLogic.gestioneProfiliControl;

import it.unisa.justTraditions.applicationLogic.autenticazioneControl.util.SessionCliente;
import it.unisa.justTraditions.storage.gestioneAnnunciStorage.dao.AnnuncioDao;
import it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity.Annuncio;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.dao.ArtigianoDao;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.entity.Artigiano;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/visualizzazioneProfiloArtigiano")
public class VisualizzazioneProfiloArtigianoController {

    private static final String visualizzazioneProfiloArtigianoView =
            "gestioneProfiliView/visualizzazioneProfiloArtigiano";

    @Autowired
    private SessionCliente sessionCliente;
    @Autowired
    private ArtigianoDao artigianoDao;

    @Autowired
    private AnnuncioDao annuncioDao;

    @GetMapping
    public ModelAndView get(@RequestParam Long id, @RequestParam(defaultValue = "0", required = false) Integer pagina,
                            Model model) {


        Artigiano artigiano = artigianoDao.findById(id).orElseThrow(IllegalArgumentException::new);


        Page<Annuncio> annuncioPage = annuncioDao.findByArtigiano(
                artigiano,
                PageRequest.of(pagina, 4, Sort.by(Sort.Direction.DESC, "id"))
        );

        List<Annuncio> annunci;


        int totalPages = annuncioPage.getTotalPages();
        if (totalPages == 0) {
            annunci = List.of();
        } else if (totalPages <= pagina) {
            throw new IllegalArgumentException();
        } else {
            annunci = annuncioPage.getContent();
        }

        model.addAttribute("annunci", annunci);
        model.addAttribute("pagina", pagina);
        model.addAttribute("pagineTotali", totalPages);
        model.addAttribute("artigiano", artigiano);


        return new ModelAndView(visualizzazioneProfiloArtigianoView);
    }
}
