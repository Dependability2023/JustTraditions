package it.unisa.justTraditions.applicationLogic.gestioneProfiliControl.form;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = ExsistEmailAmministratoreValidator.class)
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExsistEmailAmministratoreConstraint {

  String message() default "Email già esistente";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
