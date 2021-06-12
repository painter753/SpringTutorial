package com.lazyprod;

import com.lazyprod.service.quiz.QuizService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        QuizService service = context.getBean(QuizService.class);
        service.startQuiz();


    }

}
