package com.lazyprod.service.quiz;

import com.lazyprod.domain.person.Person;
import com.lazyprod.domain.quiz.QuizOption;
import com.lazyprod.domain.quiz.QuizResult;
import com.lazyprod.domain.quiz.QuizTask;
import com.lazyprod.domain.quiz.QuizTasksPack;
import com.lazyprod.service.io.IOService;
import org.springframework.stereotype.Service;

@Service
public class QuizProcessorImpl implements QuizProcessor {

    private IOService ioService;

    public QuizProcessorImpl(IOService ioService) {
        this.ioService = ioService;
    }

    @Override
    public QuizResult startQuizForPerson(Person person, QuizTasksPack quizTasksPack) {
        ioService.writeLocalizedMessage("message.quiz.start-quiz");
        quizTasksPack.getQuizTasks();

        int totalRightAnswers = 0;
        int questionCounter = 1;

        for (QuizTask quizTask : quizTasksPack.getQuizTasks()) {
            ioService.writeMessage(questionCounter + ". " + quizTask.getQuestion() + "\n");
            int optionCounter = 1;
            int rightOption = 0;
            for (QuizOption option : quizTask.getOptions()) {
                if (option.isCorrectAnswer()) rightOption = optionCounter;
                ioService.writeMessage("\t" + optionCounter + ". " + option.toString() + "\n");
                optionCounter++;
            }
            ioService.writeLocalizedMessage("message.quiz.answer.got");
            String answerStr = null;
            Integer answer = null;
            while ((answerStr = ioService.read()) != null ) {
                try {
                    answer = Integer.parseInt(answerStr);
                    break;
                } catch (Exception e) {
                    ioService.writeLocalizedMessage("message.quiz.answer.warning");
                }
            }

            if (answer.equals(rightOption)) {
                ioService.writeLocalizedMessage("message.quiz.answer.right");
                totalRightAnswers++;
            } else {
                ioService.writeLocalizedMessage("message.quiz.answer.wrong");
            }
            questionCounter++;


        }
        return new QuizResult(person, totalRightAnswers);
    }
}
