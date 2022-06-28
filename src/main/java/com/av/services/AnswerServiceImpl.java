package com.av.services;

import com.av.domain.Answer;
import com.av.domain.Question;
import com.av.domain.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.av.repositories.QuestionReader;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

@Repository
public class AnswerServiceImpl implements AnswerService {
    private QuestionReader questionReader;
    @Autowired
    public AnswerServiceImpl(QuestionReader questionReader)
    {
        this.questionReader=questionReader;
    }

    public void readerAnswers(Subject subject) {
        List<Question> questions=questionReader.getQuestions();
        questions.forEach(question->{
            printQuestion(question);
            readerAnswer(subject, question);});
    }

    private void readerAnswer(Subject subject,Question question ) {
        Scanner in = new Scanner(System.in);
        Short answer = in.nextShort();
        subject.getAnswerList().add(new Answer(question, answer));
    }

    private void printQuestion(Question question)
    {
        System.out.println(question.getQuestion());
        question.getAnswers().stream() // Turn the list into a Stream
                .collect(HashMap::new, (h, o) -> h.put(h.size()+1, o), (h, o) -> {}) // Create a map of the index to the object
                .forEach((i, o) -> { // Now we can use a BiConsumer forEach!
                    System.out.println(String.format("%d => %s", i, o));
                });
    }

}
