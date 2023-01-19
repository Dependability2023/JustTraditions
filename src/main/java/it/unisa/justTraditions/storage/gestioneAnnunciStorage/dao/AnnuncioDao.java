package it.unisa.justTraditions.storage.gestioneAnnunciStorage.dao;

import it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity.Annuncio;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnuncioDao
    extends JpaRepository<Annuncio, Long> {
  List<Annuncio> findByNomeAttivitaContainsIgnoreCaseAndProvinciaAttivitaContains(
      String nomeAttivita,
      String provinciaAttivita,
      Pageable pageable);
}
