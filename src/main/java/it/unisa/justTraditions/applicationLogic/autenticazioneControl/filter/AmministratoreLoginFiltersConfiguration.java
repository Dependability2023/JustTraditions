package it.unisa.justTraditions.applicationLogic.autenticazioneControl.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmministratoreLoginFiltersConfiguration {
  @Autowired
  private AmministratoreLoginFilter amministratoreLoginFilter;

  @Bean
  public FilterRegistrationBean<AmministratoreLoginFilter> loggingFilter() {
    FilterRegistrationBean<AmministratoreLoginFilter>
        registrationBean
        = new FilterRegistrationBean<>();

    registrationBean.setFilter(amministratoreLoginFilter);
    registrationBean.addUrlPatterns("");
    registrationBean.setOrder(1);

    return registrationBean;
  }
}
