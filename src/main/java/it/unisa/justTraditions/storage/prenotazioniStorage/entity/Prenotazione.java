package it.unisa.justTraditions.storage.prenotazioniStorage.entity;

import it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity.Visita;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.entity.Cliente;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Prenotazione {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false, precision = 5, scale = 2)
  private BigDecimal prezzoVisita;
  @Column(nullable = false)
  private LocalDate dataVisita;
  @Column(nullable = false)
  private Integer numPersonePrenotate;
  @ManyToOne
  @JoinColumn(name = "cliente", nullable = false)
  private Cliente cliente;
  @ManyToOne
  @JoinColumn(name = "visita", nullable = false)
  private Visita visita;
}
