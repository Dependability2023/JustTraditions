package it.unisa.justTraditions.storage.prenotazioniStorage.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Prenotazione {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false, precision = 5, scale = 2)
  private BigDecimal prezzoVisita;
  @Column(nullable = false)
  private LocalDate dataVisita;
  @Column(nullable = false)
  private Integer numPersonePrenotate;
  @Column(nullable = false, length = 319)
  private String cliente;
  @Column(nullable = false)
  private Long visita;

  public Prenotazione() {
  }

  public Prenotazione(BigDecimal prezzoVisita, LocalDate dataVisita, Integer numPersonePrenotate,
                      String cliente, Long visita) {
    this.prezzoVisita = prezzoVisita;
    this.dataVisita = dataVisita;
    this.numPersonePrenotate = numPersonePrenotate;
    this.cliente = cliente;
    this.visita = visita;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public BigDecimal getPrezzoVisita() {
    return prezzoVisita;
  }

  public void setPrezzoVisita(BigDecimal prezzoVisita) {
    this.prezzoVisita = prezzoVisita;
  }

  public LocalDate getDataVisita() {
    return dataVisita;
  }

  public void setDataVisita(LocalDate dataVisita) {
    this.dataVisita = dataVisita;
  }

  public Integer getNumPersonePrenotate() {
    return numPersonePrenotate;
  }

  public void setNumPersonePrenotate(Integer numPersonePrenotate) {
    this.numPersonePrenotate = numPersonePrenotate;
  }

  public String getCliente() {
    return cliente;
  }

  public void setCliente(String cliente) {
    this.cliente = cliente;
  }

  public Long getVisita() {
    return visita;
  }

  public void setVisita(Long visita) {
    this.visita = visita;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Prenotazione that = (Prenotazione) o;

    if (!Objects.equals(id, that.id)) {
      return false;
    }
    if (!Objects.equals(prezzoVisita, that.prezzoVisita)) {
      return false;
    }
    if (!Objects.equals(dataVisita, that.dataVisita)) {
      return false;
    }
    if (!Objects.equals(numPersonePrenotate, that.numPersonePrenotate)) {
      return false;
    }
    if (!Objects.equals(cliente, that.cliente)) {
      return false;
    }
    return Objects.equals(visita, that.visita);
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (prezzoVisita != null ? prezzoVisita.hashCode() : 0);
    result = 31 * result + (dataVisita != null ? dataVisita.hashCode() : 0);
    result = 31 * result + (numPersonePrenotate != null ? numPersonePrenotate.hashCode() : 0);
    result = 31 * result + (cliente != null ? cliente.hashCode() : 0);
    result = 31 * result + (visita != null ? visita.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Prenotazione{");
    sb.append("id=").append(id);
    sb.append(", prezzoVisita=").append(prezzoVisita);
    sb.append(", dataVisita=").append(dataVisita);
    sb.append(", numPersonePrenotate=").append(numPersonePrenotate);
    sb.append(", cliente='").append(cliente).append('\'');
    sb.append(", visita=").append(visita);
    sb.append('}');
    return sb.toString();
  }
}
