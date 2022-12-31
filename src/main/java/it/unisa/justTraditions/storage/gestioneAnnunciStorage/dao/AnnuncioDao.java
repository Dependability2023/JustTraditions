package it.unisa.justTraditions.storage.gestioneAnnunciStorage.dao;

import it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity.Annuncio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnuncioDao
    extends JpaRepository<Annuncio, Long> {
}
