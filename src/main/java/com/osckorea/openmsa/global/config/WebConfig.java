package com.osckorea.openmsa.global.config;

import com.navercorp.lucy.security.xss.servletfilter.XssEscapeServletFilter;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

/**
 * WEB Config
 */
@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean // 세션에 지역설정. default는 KOREAN = 'ko'
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.KOREAN);
        return slr;
    }

    /**
     * ERROR message 설정
     *
     * @return
     */
    @Bean
    public MessageSource messageSource() {

        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:i18n/error/messages");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(3);
        messageSource.setAlwaysUseMessageFormat(true);
        messageSource.setUseCodeAsDefaultMessage(true);
        messageSource.setFallbackToSystemLocale(true);
        return messageSource;
    }

    /**
     * javax.validation message 설정
     *
     * @return
     */
    @Bean
    public MessageSource validationMessageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:i18n/validation/messages");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(3);
        messageSource.setAlwaysUseMessageFormat(true);
        messageSource.setUseCodeAsDefaultMessage(true);
        messageSource.setFallbackToSystemLocale(true);
        return messageSource;
    }

    // error
    @Bean
    public MessageSourceAccessor messageSourceAccessor() {
        return new MessageSourceAccessor(messageSource());
    }

    // validation
    @Override
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(validationMessageSource());
        return bean;
    }

    /**
     * XSS 필터 등록
     * lucy xss filter
     */

    @Bean
    public FilterRegistrationBean<XssEscapeServletFilter> filterRegistrationBean() {
        FilterRegistrationBean<XssEscapeServletFilter> filterRegistration = new FilterRegistrationBean<>();
        filterRegistration.setFilter(new XssEscapeServletFilter());
        filterRegistration.setOrder(1);
        filterRegistration.addUrlPatterns("/*");
        return filterRegistration;
    }
}
