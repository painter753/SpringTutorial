package com.lazyprod.service.quiz;

import com.lazyprod.domain.person.Person;
import com.lazyprod.domain.quiz.QuizOption;
import com.lazyprod.domain.quiz.QuizResult;
import com.lazyprod.domain.quiz.QuizTask;
import com.lazyprod.domain.quiz.QuizTasksPack;
import com.lazyprod.service.io.IOService;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class QuizProcessorImpl implements QuizProcessor {

    private IOService ioService;

    public QuizProcessorImpl(IOService ioService) {
        this.ioService = ioService;
    }

    @Override
    public QuizResult startQuizForPerson(Person person, QuizTasksPack quizTasksPack) {
        ioService.writeLocalized("message.quiz.start-quiz", Locale.GERMANY);
        quizTasksPack.getQuizTasks();

        int totalRightAnswers = 0;
        int questionCounter = 1;

        for (QuizTask quizTask : quizTasksPack.getQuizTasks()) {
            ioService.write(questionCounter + ". " + quizTask.getQuestion() + "\n");
            int optionCounter = 1;
            int rightOption = 0;
            for (QuizOption option : quizTask.getOptions()) {
                if (option.isCorrectAnswer()) rightOption = optionCounter;
                ioService.write("\t" + optionCounter + ". " + option.toString() + "\n");
                optionCounter++;
            }
            ioService.writeLocalized("message.quiz.answer.got", Locale.GERMANY);
            Integer answer = Integer.parseInt(ioService.read());

            if (answer.equals(rightOption)) {
                ioService.writeLocalized("message.quiz.answer.right", Locale.GERMANY);
                totalRightAnswers++;
            } else {
                ioService.writeLocalized("message.quiz.answer.wrong", Locale.GERMANY);
            }
            questionCounter++;


        }
        return new QuizResult(person, totalRightAnswers);
    }
}
