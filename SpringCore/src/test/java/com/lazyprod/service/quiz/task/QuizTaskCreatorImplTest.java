package com.lazyprod.service.quiz.task;

import com.lazyprod.domain.quiz.QuizTask;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Quiz task creator implementation tests")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class QuizTaskCreatorImplTest {

    private QuizTaskCreator quizTaskCreator;

    @BeforeAll
    public void prepare() {
        quizTaskCreator = new QuizTaskCreatorImpl();
    }

    @Test
    public void testCreateTask() {
        String qid = "1";
        String question = "q1";
        String option1 = "op1";
        String option2 = "op2";
        String answer = "2";

        String taskRow = Stream.of(qid, question, answer, option1, option2).collect(Collectors.joining(","));

        QuizTask task = quizTaskCreator.createTask(taskRow);

        assertAll(
                () -> assertEquals(Integer.parseInt(qid), task.getId()),
                () -> assertEquals(question, task.getQuestion()),
                () -> assertNotNull(task.getOptions()),
                () -> assertEquals(2, task.getOptions().length),
                () -> assertEquals(option1, task.getOptions()[0].getAnswer()),
                () -> assertFalse(task.getOptions()[0].isCorrectAnswer()),
                () -> assertEquals(option2, task.getOptions()[1].getAnswer()),
                () -> assertTrue(task.getOptions()[1].isCorrectAnswer())
        );

    }

}
