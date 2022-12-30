package it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.DayOfWeek;
import java.time.LocalTime;

public class Visita {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private DayOfWeek giorno;
  @Column(nullable = false)
  private LocalTime orarioInizio;
  @Column(nullable = false)
  private LocalTime orarioFine;
  @Column(nullable = false)
  private Boolean validità;
  @ManyToOne
  @JoinColumn(nullable = false)
  private Annuncio annuncio;

  public Visita() {

  }
}
