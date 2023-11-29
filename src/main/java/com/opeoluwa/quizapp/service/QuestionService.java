package com.opeoluwa.quizapp.service;

import com.opeoluwa.quizapp.model.Question;
import com.opeoluwa.quizapp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;
    public ResponseEntity<List<Question>> getAllQuestions(){
        try{
            return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {

            return new ResponseEntity<>(questionRepository.findByCategory(category) , HttpStatus.OK) ;

        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>() , HttpStatus.BAD_REQUEST) ;
    }

    public ResponseEntity<List<Question>> getQuestionsByDifficultylevel(String difficultylevel) {
        try {

            return new ResponseEntity<>(questionRepository.findByDifficultylevel(difficultylevel), HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST) ;
    }
    public ResponseEntity<String> addQuestion(Question question) {
        questionRepository.save(question);
        try {
            new ResponseEntity<>("Success", HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  new ResponseEntity<>("Success", HttpStatus.CREATED);
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
