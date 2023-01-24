package it.unisa.justTraditions.applicationLogic.prenotazioniControl.form;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = PrenotazioneIsValidValidator.class)
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PrenotazioneIsValidConstraint {
  String message() default "Prenotazione non valida";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
