package it.unisa.justTraditions.storage.prenotazioniStorage.dao;

import it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity.Annuncio;
import it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity.Visita;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.entity.Cliente;
import it.unisa.justTraditions.storage.prenotazioniStorage.entity.Prenotazione;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrenotazioneDao
    extends JpaRepository<Prenotazione, Long> {
  Page<Prenotazione> findByVisitaAnnuncioAndDataVisita(Annuncio annuncio, LocalDate dataVisita,
                                                       Pageable pageable);

  List<Prenotazione> findByVisitaAndDataVisita(Visita visita, LocalDate dataVisita);

  Page<Prenotazione> findByCliente(Cliente cliente, Pageable pageable);
}
