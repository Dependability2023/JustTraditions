package it.unisa.justTraditions.applicationLogic.gestioneProfiliControl.form;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Implementa l'annotazione per la convalida dell email di un amministratore.
 */
@Documented
@Constraint(validatedBy = ExistsEmailAmministratoreValidator.class)
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsEmailAmministratoreConstraint {

  /**
   * Implementa il messaggio di errore.
   *
   * @return Email già esistente
   */
  String message() default "Email già esistente";

  /**
   * Permetti di specificare la classe di validazione.
   *
   * @return default.
   */
  Class<?>[] groups() default {};

  /**
   * ermette di specificare un payload per trasportare le informazioni sui metadati
   * utilizzate da un client di convalida.
   *
   * @return default.
   */
  Class<? extends Payload>[] payload() default {};

}
