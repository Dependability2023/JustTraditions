package it.unisa.justTraditions.storage.gestioneAnnunciStorage.dao;

import it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity.Annuncio;
import it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity.Visita;
import java.time.DayOfWeek;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitaDao
    extends JpaRepository<Visita, Long> {
  List<Visita> findByAnnuncioAndGiornoAndValiditaTrue(Annuncio annuncio, DayOfWeek giorno);
}
