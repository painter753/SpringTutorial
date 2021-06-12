package com.lazyprod.domain.quiz;

import java.util.Collection;

public class QuizTasksPack {

    Collection<QuizTask> quizTasks;

    public QuizTasksPack(Collection<QuizTask> quizTasks) {
        this.quizTasks = quizTasks;
    }

    public Collection<QuizTask> getQuizTasks() {
        return quizTasks;
    }

}
