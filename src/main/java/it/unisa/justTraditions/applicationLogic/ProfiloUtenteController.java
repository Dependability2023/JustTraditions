package it.unisa.justTraditions.applicationLogic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/profiloutente")
public class ProfiloUtenteController {


    @GetMapping
    public ModelAndView get() {


        return new ModelAndView("visualizzazioneAnnunciView/profiloUtente");
    }
}

