package com.av.repositories;


import com.av.domain.Question;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionFileReaderImpl implements QuestionFileReader {

    @Value("${application.fileName}")
    private String fileName;

    public List<String> getQuestions() {
        try {
            final BufferedReader br = new BufferedReader(new FileReader(this.fileName));
            final List<String> questions = new ArrayList<String>();
            String line;
            while ((line = br.readLine()) != null) {
                questions.add(line);
            }
            return questions;
        }
        catch (IOException e) {
            System.out.println(String.format("Error in processing file %s: %s", this.fileName, e));
            return null;
        }
    }
}
