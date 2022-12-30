package it.unisa.justTraditions.storage.gestioneProfiliStorage.entity;

import it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity.Annuncio;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.Set;

@Entity
public class Artigiano
    extends Cliente {
  @Column(columnDefinition = "CHAR(27)")
  private String iban;
  @OneToMany(mappedBy = "artigiano")
  private Set<Annuncio> annunci;
}
