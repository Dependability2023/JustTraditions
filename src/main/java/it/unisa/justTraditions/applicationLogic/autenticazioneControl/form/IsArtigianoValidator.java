package it.unisa.justTraditions.applicationLogic.autenticazioneControl.form;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Implementa la logica per convalidare l oggetto RegistrazioneForm,
 * se l'utente registrato si e dichiarato Artigiano controllare
 * l'aggiunta dell attributo RegistrazioneForm.iban è la sua correttezza.
 */
public class IsArtigianoValidator
    implements ConstraintValidator<IsArtigianoConstraint, RegistrazioneForm> {
  /**
   * Inizializza il validatore in preparazione
   * per le isValid(RegistrazioneForm registrazioneForm, ConstraintValidatorContext).
   *
   * @param constraintAnnotation istanza di annotazione per una data dichiarazione di vincolo
   */
  @Override
  public void initialize(IsArtigianoConstraint constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
  }

  /**
   * Implementa la logica di convalida.
   *
   * @param registrazioneForm          oggetto da convalidare.
   * @param constraintValidatorContext contesto in cui viene valutato il vincolo.
   * @return true se si dichiara Artigiano e ha inserito un coretto iban
   * o se non si e dichiarato Artigiano,
   * false se non si dichiara Artigiano e non ha inserito un iban o l' iban non e corretto.
   */
  @Override
  public boolean isValid(RegistrazioneForm registrazioneForm,
                         ConstraintValidatorContext constraintValidatorContext) {
    boolean isIbanBlank =
        registrazioneForm.getIban() == null || registrazioneForm.getIban().isBlank();

    if (registrazioneForm.isArtigiano() && !isIbanBlank) {
      return registrazioneForm.getIban()
          .matches("^(it|IT)[0-9]{2}[A-Za-z][0-9]{10}[0-9A-Za-z]{12}$");
    }
    return !registrazioneForm.isArtigiano() || !isIbanBlank;
  }
}
