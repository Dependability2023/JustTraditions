package it.unisa.justTraditions.applicationLogic.gestioneAnnunciControl.form;

import jakarta.validation.constraints.NotNull;
import java.time.DayOfWeek;
import java.time.LocalTime;

public class VisitaForm {
  @NotNull(message = "giorno vuoto")
  private DayOfWeek giorno;
  @NotNull(message = "orario di inizio vuoto")
  private LocalTime orarioInizio;
  @NotNull(message = "orario di fine vuoto")
  private LocalTime orarioFine;

  public VisitaForm() {
  }

  public VisitaForm(DayOfWeek giorno, LocalTime orarioInizio, LocalTime orarioFine) {
    this.giorno = giorno;
    this.orarioInizio = orarioInizio;
    this.orarioFine = orarioFine;
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

  public DayOfWeek getGiorno() {
    return giorno;
  }

  public void setGiorno(DayOfWeek giorno) {
    this.giorno = giorno;
  }
}
