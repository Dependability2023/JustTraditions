package it.unisa.justTraditions.storage.gestioneProfiliStorage.entity;

import it.unisa.justTraditions.storage.prenotazioniStorage.entity.Prenotazione;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", length = 9)
public class Cliente
    extends Utente {
  @Column(nullable = false, unique = true, columnDefinition = "CHAR(16)")
  private String codiceFiscale;
  @OneToMany(mappedBy = "cliente")
  private Set<Prenotazione> prenotazioni;
}
