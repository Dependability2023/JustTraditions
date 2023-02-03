package it.unisa.justTraditions.applicationLogic.prenotazioniControl.json;

import java.time.LocalTime;

/**
 * Classe wrapper per l invio di una visita tramite Ajax.
 */
public class VisitaResponse {

  private Long id;
  private LocalTime orarioInizio;
  private LocalTime orarioFine;

  public VisitaResponse() {
  }

  public VisitaResponse(Long id, LocalTime orarioInizio, LocalTime orarioFine) {
    this.id = id;
    this.orarioInizio = orarioInizio;
    this.orarioFine = orarioFine;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalTime getOrarioInizio() {
    return orarioInizio;
  }

  public void setOrarioInizio(LocalTime orarioInizio) {
    this.orarioInizio = orarioInizio;
  }

  public LocalTime getOrarioFine() {
    return orarioFine;
  }

  public void setOrarioFine(LocalTime orarioFine) {
    this.orarioFine = orarioFine;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("VisitaResponse{");
    sb.append("id=").append(id);
    sb.append(", orarioInizio=").append(orarioInizio);
    sb.append(", orarioFine=").append(orarioFine);
    sb.append('}');
    return sb.toString();
  }
}
