package com.lazyprod.service.quiz.task;

import com.lazyprod.dao.quiz.QuizDao;
import com.lazyprod.domain.quiz.QuizOption;
import com.lazyprod.domain.quiz.QuizTask;
import com.lazyprod.domain.quiz.QuizTasksPack;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Epic("Quiz task service implementation tests")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class QuizTaskServiceImplTest {

    private QuizDao quizDao;
    private QuizTasksService service;

    @BeforeAll
    public void prepare() {
        this.quizDao = mock(QuizDao.class);
        this.service = new QuizTasksServiceImpl(quizDao);
    }

    @Test
    public void testGetQuizPack() {
        QuizTask task = new QuizTask(1, "q", new QuizOption[0]);

        when(quizDao.getQuizTasks()).thenReturn(Stream.of(task).collect(Collectors.toList()));

        QuizTasksPack quizPack = service.getQuizPack();

        assertAll(
                () -> assertNotNull(quizPack),
                () -> assertNotNull(quizPack.getQuizTasks()),
                () -> assertEquals(1, quizPack.getQuizTasks().size()),
                () -> assertSame(task, quizPack.getQuizTasks().stream().findFirst().get())
        );
    }



}
