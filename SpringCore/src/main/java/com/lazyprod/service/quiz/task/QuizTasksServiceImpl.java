package com.lazyprod.service.quiz.task;

import com.lazyprod.dao.quiz.QuizDao;
import com.lazyprod.domain.quiz.QuizTasksPack;
import com.lazyprod.domain.quiz.QuizTask;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class QuizTasksServiceImpl implements QuizTasksService {

    private QuizDao quizDao;

    public QuizTasksServiceImpl(QuizDao quizDao) {
        this.quizDao = quizDao;
    }

    @Override
    public QuizTasksPack getQuizPack() {
        Collection<QuizTask> quizTasks = quizDao.getQuizTasks();
        QuizTasksPack quizTasksPack = new QuizTasksPack(quizTasks);

        return quizTasksPack;
    }

}
