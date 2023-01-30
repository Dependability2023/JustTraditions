package it.unisa.justTraditions.applicationLogic.autenticazioneControl.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteLoginFilterConfiguration {

    @Autowired
    private ClienteLoginFilter clienteLoginFilter;

    @Bean
    public FilterRegistrationBean<ClienteLoginFilter> filterRegistrationBeanClienteLogin() {
        FilterRegistrationBean<ClienteLoginFilter> registrationBean
                = new FilterRegistrationBean<>();

        registrationBean.setFilter(clienteLoginFilter);
        registrationBean.addUrlPatterns("/modificaProfilo", "/visualizzazioneProfiloPersonale",
                "/visualizzazionePrenotazioniPersonali", "/cancellazioneAccount", "/effettuaPrenotazione");

        return registrationBean;
    }
}
