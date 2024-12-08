package com.jadhav.quizapp.controller;

import com.jadhav.quizapp.entity.Question;
import com.jadhav.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @PostMapping("addOrUpdateQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        String response = "failed";
        try {
            questionService.addOrUpdateQuestion(question);
            response = "sucess";
        }catch (Exception ex){
            //print log
            response = "failed";
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("deleteQuestion/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Long id){
        String response = "failed";
        try {
            questionService.deleteQuestion(id);
            response = "sucess";
        }catch (Exception ex){
            //print log
            response = "failed";
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("getAllQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        List questionsList = new ArrayList<>();

        try {
            questionsList = questionService.getAllQuestions();
        }catch (Exception ex){
            //log ex
        }
        return new ResponseEntity<>(questionsList,HttpStatus.OK);
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        List<Question> questionsList = new ArrayList<>();
        try {
            questionsList = questionService.getQuestionsByCategory(category);
        }catch (Exception ex){
            //log ex
        }
        return  new ResponseEntity<>(questionsList,HttpStatus.OK);
    }

}
