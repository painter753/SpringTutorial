package com.lazyprod.service.quiz;

import com.lazyprod.domain.person.Person;
import com.lazyprod.domain.quiz.QuizTasksPack;
import com.lazyprod.domain.quiz.QuizResult;

public interface QuizProcessor {

    QuizResult startQuizForPerson(Person person, QuizTasksPack quizTasksPack);

}
