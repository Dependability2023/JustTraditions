package it.unisa.justTraditions.applicationLogic.autenticazioneControl.util;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = IsArtigianoValidator.class)
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsArtigianoConstraint {
  String message() default "Inserire l iban per poter essere un artigiano ";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
