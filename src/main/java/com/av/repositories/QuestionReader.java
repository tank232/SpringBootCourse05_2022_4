package com.av.repositories;


import com.av.domain.Question;

import java.util.List;

public interface QuestionReader {
    List<Question> getQuestions();
}
