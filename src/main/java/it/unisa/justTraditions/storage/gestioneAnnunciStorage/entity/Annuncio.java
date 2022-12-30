package it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity;

import it.unisa.justTraditions.storage.gestioneProfiliStorage.entity.Amministratore;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.entity.Artigiano;
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
import java.math.BigDecimal;
import java.util.Set;

@Entity
public class Annuncio {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false, length = 40)
  private String nomeAttivita;
  @Column(nullable = false, length = 21)
  private String provinciaAttivita;
  @Column(nullable = false, length = 128)
  private String indirizzoAttivita;
  @Column(nullable = false, length = 1024)
  private String descrizione;
  @Column(nullable = false)
  private String serviziOfferti;
  @Column(nullable = false)
  private Integer numMaxPersonaPerVisita;
  @Column(nullable = false, precision = 5, scale = 2)
  private BigDecimal prezzoVisita;
  @Enumerated(EnumType.STRING)
  @Column(nullable = false, length = 12)
  private Stato stato;
  private String motivoDelRifiuto;
  @ManyToOne
  @JoinColumn(name = "amministratore")
  private Amministratore amministratore;
  @ManyToOne
  @JoinColumn(name = "artigiano", nullable = false)
  private Artigiano artigiano;
  @OneToMany(mappedBy = "annuncio")
  private Set<Visita> visite;
  @OneToMany(mappedBy = "annuncio")
  private Set<Foto> foto;

  public Annuncio() {
  }

  public enum Stato {
    PROPOSTO,
    IN_REVISIONE,
    RIFIUTATO,
    APPROVATO
  }
}
