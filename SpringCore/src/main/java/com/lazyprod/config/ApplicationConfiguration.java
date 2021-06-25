package com.lazyprod.config;

import com.lazyprod.ApplicationProperties;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;

import java.util.Locale;

@Configuration
public class ApplicationConfiguration {

    @Bean("locale")
    public Locale locale(Environment environment) {
        String userLocale = environment.getProperty("locale");

        Locale locale = null;

        if (userLocale != null) {
            String language = userLocale.split("_")[0];
            String country = userLocale.split("_")[1].toUpperCase();
            locale = new Locale(language, country);
        } else {
            locale = Locale.getDefault();
        }

        return locale;
    }

    @Bean("quizTasksSource")
    public String quizTasksSource(
            ApplicationProperties applicationProperties,
            @Qualifier("locale") Locale locale
    ) {
        ApplicationProperties.Quiz.Tasks.Source.File file = applicationProperties.getQuiz().getTasks().getSource().getFile();
        return file.getPattern() + "_" + locale + file.getExtension();
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms =
                new ReloadableResourceBundleMessageSource();
        ms.setBasename("/i18n/bundle");
        ms.setDefaultEncoding("UTF-8");

        return ms;
    }

}
