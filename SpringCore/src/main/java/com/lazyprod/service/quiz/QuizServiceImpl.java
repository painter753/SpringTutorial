package com.lazyprod.service.quiz;

import com.lazyprod.domain.person.Person;
import com.lazyprod.domain.quiz.QuizTasksPack;
import com.lazyprod.domain.quiz.QuizResult;
import com.lazyprod.service.io.IOService;
import com.lazyprod.service.person.PersonService;
import com.lazyprod.service.quiz.task.QuizTasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImpl implements QuizService {

    private PersonService personService;
    private QuizTasksService quizTasksService;
    private QuizProcessor quizProcessor;
    private IOService ioService;
    private MessageSource messageSource;

    @Autowired
    public QuizServiceImpl(PersonService personService, QuizTasksService quizTasksService, QuizProcessor quizProcessor, IOService ioService, MessageSource messageSource) {
        this.personService = personService;
        this.quizTasksService = quizTasksService;
        this.quizProcessor = quizProcessor;
        this.ioService = ioService;
        this.messageSource = messageSource;
    }

    public QuizServiceImpl(PersonService personService, QuizTasksService quizTasksService, QuizProcessor quizProcessor, IOService ioService) {
        this.personService = personService;
        this.quizTasksService = quizTasksService;
        this.quizProcessor = quizProcessor;
        this.ioService = ioService;
    }

    @Override
    public QuizResult startQuiz() {
        ioService.writeLocalizedMessage("message.quiz.welcome");
        Person person = personService.welcomePerson();
        QuizTasksPack quizTasksPack = quizTasksService.getQuizPack();
        QuizResult quizResult = quizProcessor.startQuizForPerson(person, quizTasksPack);
        ioService.writeLocalizedMessage("message.quiz.result", person, quizResult.getRightAnswersCounter());

        return quizResult;
    }

    @Override
    public QuizResult resumeQuiz() {
        throw new UnsupportedOperationException("Not implemented");
    }
}
