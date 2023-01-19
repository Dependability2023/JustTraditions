package it.unisa.justTraditions.applicationLogic.visualizzazioneAnnunciControl;

import it.unisa.justTraditions.storage.gestioneAnnunciStorage.dao.FotoDao;
import it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity.Foto;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/img")
@Controller
public class ImgController {
  @Autowired
  FotoDao fotoDao;

  @GetMapping()
  void showImage(@RequestParam() Long id, HttpServletResponse response)
      throws ServletException, IOException {

    System.out.println(id);
    Foto foto = fotoDao.findById(id).get();

    response.setContentType("image/jpeg");
    response.getOutputStream().write(foto.getDati());
    
  }
}
