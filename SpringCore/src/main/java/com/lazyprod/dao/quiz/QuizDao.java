package com.lazyprod.dao.quiz;

import com.lazyprod.domain.quiz.QuizTask;

import java.util.Collection;

public interface QuizDao {

    Collection<QuizTask> getQuizTasks();

}
