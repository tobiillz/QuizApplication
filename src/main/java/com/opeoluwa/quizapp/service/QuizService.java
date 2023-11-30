package com.opeoluwa.quizapp.service;

import com.opeoluwa.quizapp.model.Question;
import com.opeoluwa.quizapp.model.QuestionWrapper;
import com.opeoluwa.quizapp.model.Quiz;
import com.opeoluwa.quizapp.repository.QuestionRepository;
import com.opeoluwa.quizapp.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();
        for(Question q: questionsFromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestion_title(), q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionsForUser.add(qw);
        }

        return new ResponseEntity<>(questionsForUser,HttpStatus.OK);
    }
}