package com.lazyprod.service.quiz;


import com.lazyprod.domain.quiz.QuizResult;

public interface QuizService {

    QuizResult startQuiz();
    QuizResult resumeQuiz();

}
