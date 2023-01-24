package it.unisa.justTraditions.applicationLogic.prenotazioniControl.form;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DataVisitaIsValidValidator
    implements ConstraintValidator<DataVisitaIsValidConstraint, String> {

  @Override
  public void initialize(DataVisitaIsValidConstraint constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
  }

  @Override
  public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
    return true;
  }
}
