package com.av.services;

import com.av.domain.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Scanner;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Value("${application.locale}")
    private String locale;
    private MessageSource messageSource;

    public SubjectServiceImpl( MessageSource messageSource) {
        this.messageSource = messageSource;
    }
    @Override
    public Subject readerSubject() {
        System.out.println(messageSource.getMessage("input.name", (Object[])new String[0], Locale.forLanguageTag(this.locale)));
        final Scanner in = new Scanner(System.in);
        final String subjectName = in.next();
        return new Subject(subjectName);
    }

}
