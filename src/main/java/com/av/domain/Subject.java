package com.av.domain;

import java.util.ArrayList;
import java.util.List;


public class Subject {
    private List<Answer> answerList;
    private String SubjectName;

    public Subject(String subjectName) {
        SubjectName = subjectName;
        answerList=new ArrayList<>();
    }


    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public String getSubjectName() {
        return SubjectName;
    }
}
