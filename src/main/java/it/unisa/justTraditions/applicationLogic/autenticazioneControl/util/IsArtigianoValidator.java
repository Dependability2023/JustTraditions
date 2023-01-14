package it.unisa.justTraditions.applicationLogic.autenticazioneControl.util;

import it.unisa.justTraditions.applicationLogic.autenticazioneControl.form.RegistrazioneForm;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IsArtigianoValidator
    implements ConstraintValidator<IsArtigianoConstraint, RegistrazioneForm> {
  @Override
  public void initialize(IsArtigianoConstraint constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
  }

  @Override
  public boolean isValid(RegistrazioneForm registrazioneForm,
                         ConstraintValidatorContext constraintValidatorContext) {
    return !registrazioneForm.isArtigiano() || !registrazioneForm.getIban().isBlank();
  }
}
