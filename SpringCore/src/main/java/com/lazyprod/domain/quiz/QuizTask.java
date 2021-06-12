package com.lazyprod.domain.quiz;

public class QuizTask {

    private int id;
    private String question;
    private QuizOption[] options;

    public QuizTask(int id, String question, QuizOption[] options) {
        this.id = id;
        this.question = question;
        this.options = options;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(id + ". " + question + "\n");
        int i = 1;
        for (QuizOption option : options) {
            builder.append("\t").append(i++).append(".").append(option).append("\n");
        }
        return builder.toString();
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public QuizOption[] getOptions() {
        return options;
    }
}
