package it.unisa.justTraditions.applicationLogic.autenticazioneControl.util;

import it.unisa.justTraditions.storage.gestioneProfiliStorage.dao.ClienteDao;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class ExsistEmailValidator implements ConstraintValidator<ExsistEmailConstraint, String> {
  @Autowired
  ClienteDao clienteDao;

  @Override
  public void initialize(ExsistEmailConstraint constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
  }

  @Override
  public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {

    return !clienteDao.existsByEmail(email);

  }
}
