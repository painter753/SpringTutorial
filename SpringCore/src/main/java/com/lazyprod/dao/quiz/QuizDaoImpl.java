package com.lazyprod.dao.quiz;

import com.lazyprod.domain.quiz.QuizTask;
import com.lazyprod.service.quiz.task.QuizTaskCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Component
public class QuizDaoImpl implements QuizDao {

    private QuizTaskCreator quizTaskCreator;

    private final String source;

    @Autowired
    public QuizDaoImpl(QuizTaskCreator quizTaskCreator, @Qualifier("quizTasksSource") String source) {
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
