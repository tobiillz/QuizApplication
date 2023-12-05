package com.opeoluwa.quizapp.controller;
import com.opeoluwa.quizapp.model.Question;
import com.opeoluwa.quizapp.model.QuestionWrapper;
import com.opeoluwa.quizapp.model.Response;
import com.opeoluwa.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    //CREATE A QUIZ BY PASSING category, number of questions and a title for the quiz.

    //http://localhost:8090/quiz/create?category=java&numQ=3&title=Java-Test
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title){
        return quizService.createQuiz(category,numQ,title);
    }
    //GET QUIZ BY ITS ID
    //http://localhost:8090/quiz/get/24
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }

    //API TO SUBMIT ANSWERS FOR EACH SET OF QUIZ QUESTIONS - THE ID SPECIFIES THE ID OF THE QUIZ - THE ORDER OF
    //http://loclhost:8090/quiz/submit/1
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.CalculateResult(id, responses);
    }

}
