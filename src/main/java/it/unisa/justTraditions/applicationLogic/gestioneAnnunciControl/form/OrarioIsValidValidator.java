package it.unisa.justTraditions.applicationLogic.gestioneAnnunciControl.form;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class OrarioIsValidValidator
    implements ConstraintValidator<OrarioIsValidConstraint, VisitaForm> {
  @Override
  public boolean isValid(VisitaForm visitaForm,
                         ConstraintValidatorContext constraintValidatorContext) {


    return visitaForm.getOrarioFine().isAfter(visitaForm.getOrarioInizio());
  }

  @Override
  public void initialize(OrarioIsValidConstraint constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
  }
}
