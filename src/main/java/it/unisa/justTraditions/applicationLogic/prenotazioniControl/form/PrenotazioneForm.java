package it.unisa.justTraditions.applicationLogic.prenotazioniControl.form;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@PrenotazioneIsValidConstraint
public class PrenotazioneForm {

  @NotNull
  private Long idVisita;

  @NotNull
  @Min(1)
  private Integer numeroPersone;

  @NotNull
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate dataVisita;

  public PrenotazioneForm() {
  }

  public PrenotazioneForm(Long idVisita, Integer numeroPersone, LocalDate dataVisita) {
    this.idVisita = idVisita;
    this.numeroPersone = numeroPersone;
    this.dataVisita = dataVisita;
  }

  public Long getIdVisita() {
    return idVisita;
  }

  public void setIdVisita(Long idVisita) {
    this.idVisita = idVisita;
  }

  public Integer getNumeroPersone() {
    return numeroPersone;
  }

  public void setNumeroPersone(Integer numeroPersone) {
    this.numeroPersone = numeroPersone;
  }

  public LocalDate getDataVisita() {
    return dataVisita;
  }

  public void setDataVisita(LocalDate dataVisita) {
    this.dataVisita = dataVisita;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("PrenotazioneForm{");
    sb.append("idVisita=").append(idVisita);
    sb.append(", numeroPersone=").append(numeroPersone);
    sb.append(", dataVisita=").append(dataVisita);
    sb.append('}');
    return sb.toString();
  }
}
