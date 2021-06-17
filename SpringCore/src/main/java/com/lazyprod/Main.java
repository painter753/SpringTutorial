package com.lazyprod;

import com.lazyprod.service.quiz.QuizService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyResourceConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@PropertySource("classpath:application.properties")
@Configuration
@ComponentScan("com.lazyprod")
public class Main {

    @Bean("quizTasksSource")
    public String quizTasksSource(@Value("${quiz.tasks.source}") String s) {
        return s;
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
