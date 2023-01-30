package it.unisa.justTraditions.applicationLogic.autenticazioneControl.form;

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
        boolean isIbanBlank =
                registrazioneForm.getIban() == null || registrazioneForm.getIban().isBlank();

        if (registrazioneForm.isArtigiano() && !isIbanBlank) {
            return registrazioneForm.getIban()
                    .matches("^(it|IT)[0-9]{2}[A-Za-z][0-9]{10}[0-9A-Za-z]{12}$");
        }
        return !registrazioneForm.isArtigiano() || !isIbanBlank;
    }
}
