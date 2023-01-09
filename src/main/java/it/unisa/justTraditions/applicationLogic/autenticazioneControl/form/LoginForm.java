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
  private String password;

  public LoginForm() {

  }

  public LoginForm(String email, String passworld) {
    this.email = email;
    this.password = passworld;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
