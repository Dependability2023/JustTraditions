package it.unisa.justTraditions.applicationLogic.autenticazioneControl.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArtigianoLoginFilterConfiguration {

    @Autowired
    private ArtigianoLoginFilter artigianoLoginFilter;

    @Bean
    public FilterRegistrationBean<ArtigianoLoginFilter> filterRegistrationBeanArtigianoLogin() {
        FilterRegistrationBean<ArtigianoLoginFilter> registrationBean
                = new FilterRegistrationBean<>();

        registrationBean.setFilter(artigianoLoginFilter);
        registrationBean.addUrlPatterns("/sottomissioneAnnuncio", "/rimozioneAnnuncio",
                "/modificaAnnuncio", "/visualizzazioneListaAnnunciSottomessi",
                "/visualizzazionePrenotazioniAnnuncio");

        return registrationBean;
    }
}
