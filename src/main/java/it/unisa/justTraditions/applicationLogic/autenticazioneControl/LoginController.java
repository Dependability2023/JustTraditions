package it.unisa.justTraditions.applicationLogic.autenticazioneControl;

import it.unisa.justTraditions.applicationLogic.autenticazioneControl.form.LoginForm;
import it.unisa.justTraditions.applicationLogic.autenticazioneControl.util.SessionCliente;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.dao.ClienteDao;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.entity.Cliente;
import jakarta.validation.Valid;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class LoginController {
  @Autowired
  ClienteDao clienteDao;
  @Autowired
  SessionCliente sessionCliente;

  @GetMapping
  public ModelAndView get() {
    return new ModelAndView("autenticazioneView/login")
        .addObject("loginForm", new LoginForm());
  }

  @PostMapping
  public String post(@ModelAttribute @Valid LoginForm loginForm,
                     BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
      return "autenticazioneView/login";
    }
    Optional<Cliente> cliente = clienteDao.findByEmail(loginForm.getEmail());
    try {
      sessionCliente.setCliente(cliente.orElseThrow());
    } catch (Exception e) {
      return "autenticazioneView/login";
    }

    return "redirect:/";


  }
}
