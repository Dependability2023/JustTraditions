package it.unisa.justTraditions.applicationLogic.autenticazioneControl.form;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotazione per la convalida di un oggetto RegistrazioneForm se l'utente
 * registrato si e dichiarato Artigiano controllare.
 * * l'aggiunta dell attributo RegistrazioneForm.iban è la sua correttezza.
 */
@Documented
@Constraint(validatedBy = IsArtigianoValidator.class)
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsArtigianoConstraint {
  String message() default "Aggiungi un iban valido se vuoi essere un Artigiano";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
