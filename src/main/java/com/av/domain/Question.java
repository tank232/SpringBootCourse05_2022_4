package com.av.domain;

import java.util.ArrayList;
import java.util.List;

public class Question {

    public Question() {
        answers = new ArrayList<>();
    }

    private String id;
    private String question;
    private short rightAnswer;
    private List<String> answers;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public short getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(short rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return (
                "TestCase{" +
                        "id=" +
                        id +
                        ", question='" +
                        question +
                        '\'' +
                        ", rightAnswer=" +
                        rightAnswer +
                        ", answers=" +
                        answers +
                        '}'
        );
    }
}
