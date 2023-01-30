package it.unisa.justTraditions.applicationLogic.autenticazioneControl.form;

import it.unisa.justTraditions.applicationLogic.autenticazioneControl.util.SessionCliente;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.dao.ClienteDao;
import it.unisa.justTraditions.storage.gestioneProfiliStorage.entity.Cliente;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

public class ExistsEmailValidator
        implements ConstraintValidator<ExistsEmailConstraint, String> {

    @Autowired
    private ClienteDao clienteDao;

    @Autowired
    private SessionCliente sessionCliente;

    @Override
    public void initialize(ExistsEmailConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        Optional<Cliente> optionalCliente = sessionCliente.getCliente();
        if (optionalCliente.isEmpty()) {
            return !clienteDao.existsByEmail(email);
        } else {
            Cliente cliente = optionalCliente.get();
            if (cliente.getEmail().equals(email)) {
                return true;
            } else {
                return !clienteDao.existsByEmail(email);
            }
        }
    }
}
