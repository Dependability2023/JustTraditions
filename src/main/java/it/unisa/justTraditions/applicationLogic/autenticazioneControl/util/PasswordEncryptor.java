package it.unisa.justTraditions.applicationLogic.autenticazioneControl.util;

public interface PasswordEncryptor {
  String encryptPassword(String password);

  boolean checkPassword(String password, String encryptedPassword);
}
