package it.unisa.justTraditions.applicationLogic.autenticazioneControl.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmministratoreLoginFilterConfiguration {

    @Autowired
    private AmministratoreLoginFilter amministratoreLoginFilter;

    @Bean
    public FilterRegistrationBean<AmministratoreLoginFilter> filterRegistrationBeanAmministratore() {
        FilterRegistrationBean<AmministratoreLoginFilter> registrationBean
                = new FilterRegistrationBean<>();

        registrationBean.setFilter(amministratoreLoginFilter);
        registrationBean.addUrlPatterns("/modificaStatoAnnuncio", "/rimozioneAmministratore",
                "/visualizzazioneAmministratori", "/visualizzazioneListaAnnunci", "/homeAmministratore",
                "/aggiuntaAmministratore");

        return registrationBean;
    }
}