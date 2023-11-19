package com.opeoluwa.quiz.controller;

import com.opeoluwa.quiz.model.Question;
import com.opeoluwa.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/allquestions")
    public List<Question> getAllQuestions(){
        System.out.println("Number of questions: " + questionService.getAllQuestions().size()); // Add this line for logging
        return questionService.getAllQuestions();
    }
}
