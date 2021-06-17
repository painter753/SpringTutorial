package com.lazyprod.service.quiz.task;

import com.lazyprod.domain.quiz.QuizOption;
import com.lazyprod.domain.quiz.QuizTask;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class QuizTaskCreatorImpl implements QuizTaskCreator {

    @Override
    public QuizTask createTask(String row) {
        String[] columns = row.split(",");

        int id = Integer.parseInt(columns[0].trim());
        String question = columns[1];

        int rightAnswer = Integer.parseInt(columns[columns.length - 1].trim());

        Collection<QuizOption> options = new ArrayList<>();
        for (int i = 2; i < columns.length - 1; i++) {
            boolean isCorrect = false;
            if (rightAnswer == i - 1) {
                isCorrect = true;
            }

            QuizOption option = new QuizOption(columns[i].trim(), isCorrect);
            options.add(option);
        }
        QuizTask quizTask = new QuizTask(id, question, options.toArray(new QuizOption[0]));
        return quizTask;
    }
}
