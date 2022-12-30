package it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.Set;

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
  @Column(nullable = false, length = 12)
  private String stato;
  @Column(nullable = false)
  private String motivoDelRifiuto;
  @ManyToOne
  private Amministratore amministratore;
  @ManyToOne
  @JoinColumn(nullable = false)
  private Artigiano artigiano;
  @OneToMany(mappedBy = "visite")
  private Set<Visita> visite;
  @OneToMany(mappedBy = "foto")
  private Set<Foto> foto;


  public Annuncio() {
  }


}
