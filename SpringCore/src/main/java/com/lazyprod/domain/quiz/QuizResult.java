package com.lazyprod.domain.quiz;

import com.lazyprod.domain.person.Person;

public class QuizResult {

    private Person person;
    private Integer rightAnswersCounter;

    public QuizResult(Person person, int rightAnswersCounter) {
        this.person = person;
        this.rightAnswersCounter = rightAnswersCounter;
    }

    public Person getPerson() {
        return person;
    }

    public Integer getRightAnswersCounter() {
        return rightAnswersCounter;
    }
}
