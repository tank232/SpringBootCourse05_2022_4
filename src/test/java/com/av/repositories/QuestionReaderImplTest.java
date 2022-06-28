package com.av.repositories;

import com.av.domain.Question;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { QuestionReaderImpl.class, QuestionFileReaderImpl.class })
@TestPropertySource("classpath:application.yml")
public class QuestionReaderImplTest {

    @Autowired
    QuestionReaderImpl questionReader;
    @Autowired
    QuestionFileReaderImpl questionFileReader;

    @Test
    public void getQuestions() {
        List<Question> questions = questionReader.getQuestions();
        assertEquals(5, questions.size());
    }
}