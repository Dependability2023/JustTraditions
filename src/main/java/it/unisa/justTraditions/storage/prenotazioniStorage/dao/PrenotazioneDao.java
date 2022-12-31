package it.unisa.justTraditions.storage.prenotazioniStorage.dao;

import it.unisa.justTraditions.storage.prenotazioniStorage.entity.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrenotazioneDao
    extends JpaRepository<Prenotazione, Long> {
}
