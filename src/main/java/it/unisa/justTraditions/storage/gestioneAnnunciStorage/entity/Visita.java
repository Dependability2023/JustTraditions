package it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity;

import it.unisa.justTraditions.storage.prenotazioniStorage.entity.Prenotazione;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Set;

@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"annuncio", "giorno", "orarioInizio", "orarioFine"})
})
public class Visita {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Enumerated(EnumType.STRING)
  @Column(nullable = false, length = 9)
  private DayOfWeek giorno;
  @Column(nullable = false)
  private LocalTime orarioInizio;
  @Column(nullable = false)
  private LocalTime orarioFine;
  @Column(nullable = false)
  private Boolean validita;
  @ManyToOne
  @JoinColumn(name = "annuncio", nullable = false)
  private Annuncio annuncio;
  @OneToMany(mappedBy = "visita")
  private Set<Prenotazione> prenotazioni;

  public Visita() {
  }
}
