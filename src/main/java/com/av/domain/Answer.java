package com.av.domain;

public class Answer {
    private Question question;
    private short answer;

    public Answer(Question question, short answer) {
        this.question = question;
        this.answer = answer;
    }

    public short getAnswer() {
        return answer;
    }

    public Question getQuestion() {
        return question;
    }
}
