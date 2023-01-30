package it.unisa.justTraditions.applicationLogic.autenticazioneControl.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@IsArtigianoConstraint
public class RegistrazioneForm {
    @NotBlank(message = "Nome vuoto")
    @Size(max = 30, message = "Nome troppo lungo")
    private String nome;

    @NotBlank(message = "Cognome vuoto")
    @Size(max = 30, message = "Cognome troppo lungo")
    private String cognome;

    @NotBlank(message = "Codice Fiscale vuoto")
    @Pattern(regexp = "^[a-zA-Z]{6}[0-9]{2}[a-zA-Z][0-9]{2}[a-zA-Z][0-9]{3}[a-zA-Z]$",
            message = "Formato codice fiscale errato")
    @Size(max = 16, message = "Codice Fiscale troppo lungo")
    private String codiceFiscale;

    @NotBlank(message = "Email vuota")
    @Email(message = "Formato email errato")
    @Size(max = 319, message = "Email troppo lunga")
    @ExistsEmailConstraint
    private String email;

    @NotBlank(message = "Password vuota")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*\\p{Punct})[A-Za-z\\d\\p{Punct}]{8,}$",
            message =
                    "La password deve contenere almeno 8 caratteri, di cui almeno una lettera maiuscola, "
                            + "almeno una minuscola, almeno un numero e almeno un carattere speciale"
    )
    private String password;

    @NotNull(message = "Parametro artigiano mancante")
    private Boolean artigiano;

    @Size(max = 27, message = "Iban troppo lungo")
    private String iban;

    public RegistrazioneForm() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean isArtigiano() {
        return this.artigiano;
    }

    public Boolean getArtigiano() {
        return this.artigiano;
    }

    public void setArtigiano(Boolean artigiano) {
        this.artigiano = artigiano;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }
}
