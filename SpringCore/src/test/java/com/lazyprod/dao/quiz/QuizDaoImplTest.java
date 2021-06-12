package com.lazyprod.dao.quiz;

import com.lazyprod.dao.quiz.QuizDao;
import com.lazyprod.dao.quiz.QuizDaoImpl;
import com.lazyprod.domain.quiz.QuizOption;
import com.lazyprod.domain.quiz.QuizTask;
import com.lazyprod.service.quiz.task.QuizTaskCreator;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@Epic("Quiz dao implementation tests")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class QuizDaoImplTest {

    private QuizTaskCreator quizTaskCreator;
    private String source;
    private QuizDao quizDao;

    @BeforeAll
    public void prepare() {
        this.quizTaskCreator = mock(QuizTaskCreator.class);
        this.source = "quiz/tasks.csv";
        this.quizDao = new QuizDaoImpl(quizTaskCreator, source);
    }

    @Test
    public void testGetQuizTasks() {
        QuizTask quizTask = mock(QuizTask.class);
        when(quizTaskCreator.createTask(anyString())).thenReturn(quizTask);

        Collection<QuizTask> quizTasks = quizDao.getQuizTasks();

        assertAll(
                () -> assertNotNull(quizTasks),
                () -> assertEquals(1, quizTasks.size()),
                () -> assertSame(quizTask, quizTasks.stream().findFirst().get())
        );
    }

    @Test
    public void testGetQuizTaskThrowsException() {
        //todo
        doThrow(RuntimeException.class).when(quizTaskCreator).createTask(anyString());

        Collection<QuizTask> quizTasks = quizDao.getQuizTasks();

        assertAll(
                () -> assertNotNull(quizTasks),
                () -> assertEquals(0, quizTasks.size())
        );
    }

    @AfterEach
    public void resetMocks() {
        reset(quizTaskCreator);
    }

}
