package it.unisa.justTraditions.storage.prenotazioniStorage.dao;

import it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity.Annuncio;
import it.unisa.justTraditions.storage.prenotazioniStorage.entity.Prenotazione;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrenotazioneDao
    extends JpaRepository<Prenotazione, Long> {
  List<Prenotazione> finByVisitaAnnuncioAndDataVisita(Annuncio annuncio, LocalDate dataVisita);
}
