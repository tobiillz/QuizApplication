package com.opeoluwa.quiz.service;

import com.opeoluwa.quiz.model.Question;
import com.opeoluwa.quiz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;
    public List<Question> getAllQuestions(){
        return questionRepository.findAll();
    }

}
