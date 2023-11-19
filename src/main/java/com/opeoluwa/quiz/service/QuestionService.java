package com.opeoluwa.quiz.service;

import com.opeoluwa.quiz.model.Question;
import com.opeoluwa.quiz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;
    public List<Question> getAllQuestions(){
        return questionRepository.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionRepository.findByCategory(category);
    }

    public String addQuestion(Question question) {
        questionRepository.save(question);
        return "Success";
    }

    public String deleteQuestion(Integer id){
        questionRepository.deleteById(id);
        return "Question has been deleted!!!!";

    }

    public Question updateQuestion(Question question) {
        return questionRepository.save(question);
    }

    public Optional<Question> getQuestionById(Integer id) {
        return questionRepository.findById(id);
    }
}
