package com.av.services;

import com.av.domain.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScreeningServiceImpl implements ScreeningService {

    private AnswerService answerReader;
    private SubjectService subjectReader;
    private CalcService calcService;

    @Autowired
    public ScreeningServiceImpl(CalcService calc, SubjectService subject, AnswerService answer) {
        answerReader = answer;
        subjectReader = subject;
        calcService =calc;
    }

    @Override
    public void startScreening() {
        Subject subject = subjectReader.readerSubject();
        answerReader.readerAnswers(subject);
        calcService.printCalc(subject);
    }
}
