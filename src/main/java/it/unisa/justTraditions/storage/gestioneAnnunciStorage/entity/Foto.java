package it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
public class Foto {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Lob
  @Basic(fetch = FetchType.LAZY)
  @Column(nullable = false, length = 16777215)
  private byte[] dati;
  @ManyToOne
  @JoinColumn(name = "annuncio", nullable = false)
  private Annuncio annuncio;

  public Foto() {
  }
}
