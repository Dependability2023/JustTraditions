package it.unisa.justTraditions.storage.gestioneProfiliStorage.entity;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.CascadeType.REFRESH;

import it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity.Annuncio;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Amministratore
    extends Utente {
  @OneToMany(mappedBy = "amministratore", cascade = {MERGE, PERSIST, REFRESH})
  private Set<Annuncio> annunciApprovati = new HashSet<>();

  public Amministratore() {
  }

  public Amministratore(String email, String password, String nome, String cognome) {
    super(email, password, nome, cognome);
  }

  public Set<Annuncio> getAnnunciApprovati() {
    return Collections.unmodifiableSet(annunciApprovati);
  }

  public void addAnnuncioApprovato(Annuncio annuncio) {
    annunciApprovati.add(annuncio);
    annuncio.setAmministratore(this);
  }

  public void removeAnnuncioApprovato(Annuncio annuncio) {
    annunciApprovati.remove(annuncio);
    annuncio.setAmministratore(null);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Amministratore{");
    sb.append('}').append(" is a ").append(super.toString());
    return sb.toString();
  }
}
