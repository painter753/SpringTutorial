package com.lazyprod;

import com.lazyprod.service.quiz.QuizService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(
        scanBasePackages = "com.lazyprod"
)
public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Main.class);

        QuizService service = context.getBean(QuizService.class);
        service.startQuiz();
    }

}
