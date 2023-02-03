package it.unisa.justTraditions.applicationLogic.autenticazioneControl.form;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotazione per la convalida di un email, se essa è presente all'interno di un database.
 */
@Documented
@Constraint(validatedBy = ExistsEmailValidator.class)
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsEmailConstraint {

  String message() default "Email già esistente";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
