package it.unisa.justTraditions.applicationLogic.gestioneAnnunciControl.form;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public class AnnuncioForm {

  @NotBlank(message = "Nome vuoto")
  @Size(max = 40, message = "Nome troppo lungo")
  private String nomeAttivita;

  @NotBlank(message = "Nome vuoto")
  @Size(max = 21, message = "Provincia troppo lungo")
  private String provinciaAttivita;

  @NotBlank(message = "Nome vuoto")
  @Size(max = 128, message = "Nome troppo lungo")
  private String indirizzoAttivita;

  @NotBlank(message = "Nome vuoto")
  @Size(max = 1024, message = "Nome troppo lungo")
  private String descrizione;

  @NotBlank(message = "Nome vuoto")
  @Size(max = 255, message = "Nome troppo lungo")
  private String serviziOfferti;

  @NotNull(message = "Nome vuoto")
  @Min(value = 1, message = "minimo una persona")
  private Integer numMaxPersonePerVisita;


  @NotNull(message = "Nome vuoto")
  @Digits(integer = 5, fraction = 2)
  private BigDecimal prezzoVisita;
  @NotBlank(message = "Nome vuoto")
  @Size(max = 255, message = "Nome troppo lungo")
  private String motivoDelRifiuto;
  @Size(min = 1, max = 3)
  private List<MultipartFile> foto;
  @Size(min = 1)
  private List<@Valid VisitaForm> visite;


  public AnnuncioForm() {

  }

  public String getNomeAttivita() {
    return nomeAttivita;
  }

  public void setNomeAttivita(String nomeAttivita) {
    this.nomeAttivita = nomeAttivita;
  }

  public String getProvinciaAttivita() {
    return provinciaAttivita;
  }

  public void setProvinciaAttivita(String provinciaAttivita) {
    this.provinciaAttivita = provinciaAttivita;
  }

  public String getIndirizzoAttivita() {
    return indirizzoAttivita;
  }

  public void setIndirizzoAttivita(String indirizzoAttivita) {
    this.indirizzoAttivita = indirizzoAttivita;
  }

  public String getDescrizione() {
    return descrizione;
  }

  public void setDescrizione(String descrizione) {
    this.descrizione = descrizione;
  }

  public String getServiziOfferti() {
    return serviziOfferti;
  }

  public void setServiziOfferti(String serviziOfferti) {
    this.serviziOfferti = serviziOfferti;
  }

  public Integer getNumMaxPersonePerVisita() {
    return numMaxPersonePerVisita;
  }

  public void setNumMaxPersonePerVisita(Integer numMaxPersonePerVisita) {
    this.numMaxPersonePerVisita = numMaxPersonePerVisita;
  }

  public BigDecimal getPrezzoVisita() {
    return prezzoVisita;
  }

  public void setPrezzoVisita(BigDecimal prezzoVisita) {
    this.prezzoVisita = prezzoVisita;
  }

  public String getMotivoDelRifiuto() {
    return motivoDelRifiuto;
  }

  public void setMotivoDelRifiuto(String motivoDelRifiuto) {
    this.motivoDelRifiuto = motivoDelRifiuto;
  }

  public List<MultipartFile> getFoto() {
    return foto;
  }

  public void setFoto(List<MultipartFile> foto) {
    this.foto = foto;
  }

  public List<VisitaForm> getVisite() {
    return visite;
  }

  public void setVisite(
      List<VisitaForm> visite) {
    this.visite = visite;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("AnnuncioForm{");
    sb.append("nomeAttivita='").append(nomeAttivita).append('\'');
    sb.append(", provinciaAttivita='").append(provinciaAttivita).append('\'');
    sb.append(", indirizzoAttivita='").append(indirizzoAttivita).append('\'');
    sb.append(", descrizione='").append(descrizione).append('\'');
    sb.append(", serviziOfferti='").append(serviziOfferti).append('\'');
    sb.append(", numMaxPersonePerVisita=").append(numMaxPersonePerVisita);
    sb.append(", prezzoVisita=").append(prezzoVisita);
    sb.append(", motivoDelRifiuto='").append(motivoDelRifiuto).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
