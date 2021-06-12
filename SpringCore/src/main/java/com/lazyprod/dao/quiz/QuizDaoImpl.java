package com.lazyprod.dao.quiz;

import com.lazyprod.domain.quiz.QuizTask;
import com.lazyprod.service.quiz.task.QuizTaskCreator;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class QuizDaoImpl implements QuizDao {

    private QuizTaskCreator quizTaskCreator;
    private final String source;

    public QuizDaoImpl(QuizTaskCreator quizTaskCreator, String source) {
        this.quizTaskCreator = quizTaskCreator;
        this.source = source;
    }

    @Override
    public Collection<QuizTask> getQuizTasks() {
        Collection<QuizTask> tasks = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(source)));){
            while (reader.ready()) {
                String s = reader.readLine();
                QuizTask task = quizTaskCreator.createTask(s);
                tasks.add(task);
            }
        } catch (Exception e) {
            return Collections.emptyList();
        }
        return tasks;
    }

}
