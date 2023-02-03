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

/**
 * Implementa il controller per la visualizzazione delle foto.
 */
@Controller
@RequestMapping("/img")
public class ImgController {

  @Autowired
  private FotoDao fotoDao;

  /**
   * Implementa la visualizzazione delle immagini.
   *
   * @param id       Utilizzato per la ricerca del immagine nel database.
   * @param response Utilizzato per l invio dell immagine.
   * @throws ServletException
   * @throws IOException
   */
  @GetMapping
  public void get(@RequestParam Long id, HttpServletResponse response)
      throws ServletException, IOException {
    Foto foto = fotoDao.findById(id).orElseThrow(IllegalArgumentException::new);

    response.setContentType("image/jpeg");
    response.getOutputStream().write(foto.getDati());
  }
}
