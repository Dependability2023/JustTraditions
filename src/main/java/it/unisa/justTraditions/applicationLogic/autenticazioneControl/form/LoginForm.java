package it.unisa.justTraditions.applicationLogic.autenticazioneControl.form;

public class LoginForm {
  private String email;
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
