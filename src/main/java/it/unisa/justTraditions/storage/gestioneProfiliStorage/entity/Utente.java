package it.unisa.justTraditions.storage.gestioneProfiliStorage.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Utente {
  @Id
  @Column(length = 319)
  private String email;
  @Column(nullable = false, columnDefinition = "CHAR(32)")
  private String password;
  @Column(nullable = false, length = 30)
  private String nome;
  @Column(nullable = false, length = 30)
  private String cognome;
}
