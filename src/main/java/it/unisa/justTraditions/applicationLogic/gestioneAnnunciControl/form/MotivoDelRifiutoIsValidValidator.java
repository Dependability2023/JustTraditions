package it.unisa.justTraditions.applicationLogic.gestioneAnnunciControl.form;

import it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity.Annuncio;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MotivoDelRifiutoIsValidValidator
    implements ConstraintValidator<MotivoDelRifiutoIsValidConstraint, ModificaStatoAnnuncioForm> {

  @Override
  public boolean isValid(ModificaStatoAnnuncioForm modificaStatoAnnuncioForm,
                         ConstraintValidatorContext constraintValidatorContext) {
    Annuncio.Stato nuovoStato = modificaStatoAnnuncioForm.getNuovoStato();
    boolean motivoDelRifiutoBlank = modificaStatoAnnuncioForm.getMotivoDelRifiuto() == null
        || modificaStatoAnnuncioForm.getMotivoDelRifiuto().isBlank();

    return nuovoStato != Annuncio.Stato.RIFIUTATO || !motivoDelRifiutoBlank;
  }

  @Override
  public void initialize(MotivoDelRifiutoIsValidConstraint constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
  }
}
