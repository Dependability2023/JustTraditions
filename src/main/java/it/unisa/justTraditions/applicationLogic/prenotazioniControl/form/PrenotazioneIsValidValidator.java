package it.unisa.justTraditions.applicationLogic.prenotazioniControl.form;

import it.unisa.justTraditions.storage.gestioneAnnunciStorage.dao.VisitaDao;
import it.unisa.justTraditions.storage.gestioneAnnunciStorage.entity.Visita;
import it.unisa.justTraditions.storage.prenotazioniStorage.dao.PrenotazioneDao;
import it.unisa.justTraditions.storage.prenotazioniStorage.entity.Prenotazione;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;

public class PrenotazioneIsValidValidator
    implements ConstraintValidator<PrenotazioneIsValidConstraint, PrenotazioneForm> {
  @Override
  public void initialize(PrenotazioneIsValidConstraint constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
  }

  @Autowired
  private PrenotazioneDao prenotazioneDao;
  @Autowired
  private VisitaDao visitaDao;

  @Override
  public boolean isValid(PrenotazioneForm prenotazioneForm,
                         ConstraintValidatorContext constraintValidatorContext) {

    Visita visita = visitaDao.findById(prenotazioneForm.getIdVisita())
        .orElseThrow(IllegalArgumentException::new);

    if (!prenotazioneForm.getDataVisita().isAfter(LocalDate.now())) {
      return false;
    }
    if (!prenotazioneForm.getDataVisita().getDayOfWeek().equals(visita.getGiorno())) {
      return false;
    }


    int numeroPersonePrenotate =
        prenotazioneDao.findByVisitaAndDataVisita(visita, prenotazioneForm.getDataVisita()).stream()
            .mapToInt(Prenotazione::getNumPersonePrenotate)
            .sum();
    return prenotazioneForm.getNumeroPersone() < numeroPersonePrenotate;
  }
}
