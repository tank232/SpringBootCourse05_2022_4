package com.av.repositories;


import com.av.domain.Question;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class QuestionReaderImpl implements QuestionReader {
    @Value("${application.locale}")
    private String locale;
    private final QuestionFileReader questionFileReader;
    private final MessageSource messageSource;

    public QuestionReaderImpl(final QuestionFileReader questionFileReader, final MessageSource messageSource) {
        this.questionFileReader = questionFileReader;
        this.messageSource = messageSource;
    }
    public List<Question> getQuestions() {
        List<Question> questions = new ArrayList<Question>();
        questionFileReader.getQuestions().stream().forEach(questionNumber -> {
            String line = this.messageSource.getMessage(questionNumber, new String[0], Locale.forLanguageTag(this.locale));
            String[] questionCsv = line.split(",");
            Question question = new Question();
            question.setId(questionNumber);
            question.setQuestion(questionCsv[0]);
            question.setRightAnswer(Short.parseShort(questionCsv[1]));
            question.setAnswers((List)List.of(questionCsv[2], questionCsv[3], questionCsv[4]));
            questions.add(question);
        });
        return questions;
    }

}
