package com.opeoluwa.quizapp.service;

import com.opeoluwa.quizapp.model.Question;
import com.opeoluwa.quizapp.model.Quiz;
import com.opeoluwa.quizapp.repository.QuestionRepository;
import com.opeoluwa.quizapp.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class QuizService {

    @Autowired
    QuizRepository quizRepository;
    @Autowired
    QuestionRepository questionRepository;

//    public ResponseEntity<List<Question>> getQuiz() {
//        try{
//            return new ResponseEntity<>(quizRepository.findAll(), HttpStatus.OK);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
//    }


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Question> questions = questionRepository.findRandomQuestionsByCategory(category,numQ);
        Quiz quiz = new Quiz();

        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepository.save(quiz);

        return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }
}