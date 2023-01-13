package it.unisa.justTraditions.applicationLogic.autenticazioneControl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/adminpage")
public class adminController {


    @GetMapping
    public ModelAndView get() {


        return new ModelAndView("autenticazioneView/adminPage");
    }
}

