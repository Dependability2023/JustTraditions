package it.unisa.justTraditions.storage.gestioneProfiliStorage.entity;

import it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity.Annuncio;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.Set;

@Entity
public class Amministratore
    extends Utente {
  @OneToMany(mappedBy = "amministratore")
  private Set<Annuncio> annunciApprovati;
}
