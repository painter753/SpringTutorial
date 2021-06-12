package com.lazyprod.domain.quiz;

public class QuizOption {

    private String answer;
    private boolean isCorrectAnswer;

    public QuizOption(String answer, boolean isCorrectAnswer) {
        this.answer = answer;
        this.isCorrectAnswer = isCorrectAnswer;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isCorrectAnswer() {
        return isCorrectAnswer;
    }

    @Override
    public String toString() {
        return answer;
    }
}
