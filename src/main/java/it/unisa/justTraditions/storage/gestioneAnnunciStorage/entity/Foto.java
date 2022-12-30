package it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import java.sql.Blob;

public class Foto {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  @Lob
  private byte[] dati;
  @JoinColumn(nullable = false)
  private Annuncio annuncio;

  public Foto() {

  }
}
