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

        int rightAnswer = Integer.parseInt(columns[2].trim());

        Collection<QuizOption> options = new ArrayList<>();
        for (int i = 3; i < columns.length; i++) {
            boolean isCorrect = false;
            if (rightAnswer == i - 2) {
                isCorrect = true;
            }

            QuizOption option = new QuizOption(columns[i].trim(), isCorrect);
            options.add(option);
        }
        QuizTask quizTask = new QuizTask(id, question, options.toArray(new QuizOption[0]));
        return quizTask;
    }
}
