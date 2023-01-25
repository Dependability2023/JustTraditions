package it.unisa.justTraditions.applicationLogic.gestioneProfiliControl.form;

import it.unisa.justTraditions.storage.gestioneProfiliStorage.dao.AmministratoreDao;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class ExsistEmailAmministratoreValidator
    implements ConstraintValidator<ExsistEmailAmministratoreConstraint, String> {

  @Autowired
  private AmministratoreDao amministratoreDao;

  @Override
  public void initialize(ExsistEmailAmministratoreConstraint constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
  }

  @Override
  public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
    return !amministratoreDao.existsByEmail(email);
  }
}
