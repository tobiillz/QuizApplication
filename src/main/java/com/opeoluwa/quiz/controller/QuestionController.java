package com.opeoluwa.quiz.controller;

import com.opeoluwa.quiz.model.Question;
import com.opeoluwa.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    //GET ALL QUESTIONS
    //http://localhost:8090/question/questions

    @GetMapping("/allquestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
//        System.out.println("Number of questions: " + questionService.getAllQuestions().size());
        // Add this line for logging
        return questionService.getAllQuestions() ;
    }

    //GET QUESTIONS BY CATEGORY
    //http://localhost:8090/question/category/{category}

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
//        System.out.println("Number of questions by category: "+ questionService.getQuestionsByCategory( category).size());
        return questionService.getQuestionsByCategory(category);
    }

    //GET A QUESTION BY DIFFICULTY LEVEL
    @GetMapping("/difficultylevel/{difficultylevel}")
    public ResponseEntity<List<Question>> getQuestionsByDifficultyLevel(@PathVariable String  difficultylevel){
        return questionService.getQuestionsByDifficultylevel(difficultylevel);
    }

    //GET A QUESTION BY ID
    //http://localhost:8090/question/id/{id}


    @GetMapping("/id/{id}")
    public Optional<Question> getQuestionById(@PathVariable Integer id){
        return questionService.getQuestionById(id);
    }

    //CREATE A NEW QUESTION
    //http://localhost:8090/question/
    @PostMapping()
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);

    }
    //REMOVE A QUESTION BY ID
    //http://localhost:8090/question/id
    @DeleteMapping("/{id}")
    public String deleteQuestion(@PathVariable Integer id){
        return questionService.deleteQuestion(id);
    }

    @PutMapping()
    public Question updateQuestion(@RequestBody Question question){
        return questionService.updateQuestion(question);
    }
}
