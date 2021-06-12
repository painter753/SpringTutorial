package com.lazyprod.service.quiz;

import com.lazyprod.domain.person.Person;
import com.lazyprod.domain.quiz.QuizOption;
import com.lazyprod.domain.quiz.QuizResult;
import com.lazyprod.domain.quiz.QuizTask;
import com.lazyprod.domain.quiz.QuizTasksPack;
import com.lazyprod.service.io.IOService;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Epic("Quiz processor implementation tests")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class QuizProcessorTest {

    private IOService ioService;
    private QuizProcessor quizProcessor;

    @BeforeAll
    public void prepare() {
        ioService = mock(IOService.class);
        quizProcessor = new QuizProcessorImpl(ioService);
    }

    @Test
    public void testQuiz() {
        Person person = mock(Person.class);
        QuizTask quizTask = mock(QuizTask.class);
        QuizOption option = mock(QuizOption.class);

        when(quizTask.getOptions()).thenReturn(new QuizOption[]{option, option});
        when(option.isCorrectAnswer()).thenReturn(false, true);
        when(option.getAnswer()).thenReturn("ans", "ans");
        when(ioService.read()).thenReturn("2");
        QuizTasksPack pack = new QuizTasksPack(Stream.of(quizTask).collect(Collectors.toList()));

        QuizResult result = quizProcessor.startQuizForPerson(person, pack);

        Assertions.assertAll(
                () -> Assertions.assertEquals(person, result.getPerson()),
                () -> Assertions.assertEquals(1, result.getRightAnswersCounter())
        );

    }
}
