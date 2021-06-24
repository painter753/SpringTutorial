package com.lazyprod;

import com.lazyprod.service.quiz.QuizService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;

import java.util.Locale;

@PropertySource("classpath:application.properties")
@Configuration
@ComponentScan("com.lazyprod")
public class Main {

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
            @Value("${quiz.tasks.source.file.pattern}") String pattern,
            @Value("${quiz.tasks.source.file.extension}") String extension,
            @Qualifier("locale") Locale locale
    ) {
        return pattern + "_" + locale + extension;
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms =
                new ReloadableResourceBundleMessageSource();
        ms.setBasename("/i18n/bundle");
        ms.setDefaultEncoding("UTF-8");

        return ms;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyResourceConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        QuizService service = context.getBean(QuizService.class);
        service.startQuiz();
    }

}
