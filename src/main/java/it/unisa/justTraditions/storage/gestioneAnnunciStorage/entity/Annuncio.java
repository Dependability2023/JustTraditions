package it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity;

import it.unisa.justTraditions.storage.gestioneProfiliStorage.entity.Amministratore;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.entity.Artigiano;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.HashSet;
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
  private Stato stato = Stato.PROPOSTO;
  private String motivoDelRifiuto;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "amministratore")
  private Amministratore amministratore;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "artigiano", nullable = false)
  private Artigiano artigiano;
  @OneToMany(mappedBy = "annuncio", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Visita> visite = new HashSet<>();
  @OneToMany(mappedBy = "annuncio", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Foto> foto = new HashSet<>();

  public Annuncio() {
  }

  public Annuncio(String nomeAttivita, String provinciaAttivita, String indirizzoAttivita,
                  String descrizione, String serviziOfferti, Integer numMaxPersonaPerVisita,
                  BigDecimal prezzoVisita, Artigiano artigiano) {
    this.nomeAttivita = nomeAttivita;
    this.provinciaAttivita = provinciaAttivita;
    this.indirizzoAttivita = indirizzoAttivita;
    this.descrizione = descrizione;
    this.serviziOfferti = serviziOfferti;
    this.numMaxPersonaPerVisita = numMaxPersonaPerVisita;
    this.prezzoVisita = prezzoVisita;
    this.artigiano = artigiano;
  }

  public enum Stato {
    PROPOSTO,
    IN_REVISIONE,
    RIFIUTATO,
    APPROVATO
  }
}
