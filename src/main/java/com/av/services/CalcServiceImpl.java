package com.av.services;

import com.av.domain.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class CalcServiceImpl implements CalcService{

    @Value("${application.locale}")
    private String locale;
    private MessageSource messageSource;
    @Value("${application.passRate}")
    private int passRate;


    public CalcServiceImpl(MessageSource messageSource){ this.messageSource = messageSource;}
    private int succeed(Subject subject) {
        return (int) subject.getAnswerList().stream().filter(answer->answer.getAnswer()==answer.getQuestion().getRightAnswer()).count();
    }


    public void printCalc(Subject subject) {
        final int succeed = this.succeed(subject);
        final String succeedText = this.messageSource.getMessage((succeed >= this.passRate) ? "report.pass" : "report.fail", (Object[])new String[0], Locale.forLanguageTag("ru-RU"));
        System.out.println(this.messageSource.getMessage("report.pattern", new Object[] { subject.getSubjectName(), succeed, succeedText }, Locale.forLanguageTag(this.locale)));
    }
}
