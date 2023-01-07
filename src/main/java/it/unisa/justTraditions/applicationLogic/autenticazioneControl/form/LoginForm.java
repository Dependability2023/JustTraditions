package it.unisa.justTraditions.applicationLogic.autenticazioneControl.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginForm {
  @NotBlank(message = "email vuota ")
  @Email(message = "formato email  errato")
  @Size(max = 319)
  private String email;
  @NotBlank(message = "passworld vuota ")
  private String passworld;

  public LoginForm() {

  }

  public LoginForm(String email, String passworld) {
    this.email = email;
    this.passworld = passworld;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassworld() {
    return passworld;
  }

  public void setPassworld(String passworld) {
    this.passworld = passworld;
  }
}
