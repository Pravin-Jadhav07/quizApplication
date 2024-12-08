package com.jadhav.questionService.controller;


import com.jadhav.questionService.dto.QuestonDto;
import com.jadhav.questionService.dto.ResponseDto;
import com.jadhav.questionService.entity.Question;
import com.jadhav.questionService.service.QuestionService;
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

    @GetMapping("greet")
    public ResponseEntity<String> greet(){
        return new ResponseEntity<>("Hii good morning from questionService", HttpStatus.OK);
    }

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

    @PostMapping("getQuestionIds")
    public ResponseEntity<List<Long>> getQuestionIdsForQuiz(@RequestParam String category, @RequestParam Long numOfQuestions){
        List<Long> questionIds = new ArrayList<>();
        try {
            questionIds = questionService.getQuestionIdsForQuiz(category, numOfQuestions);
        }catch (Exception ex){
            //log e
        }
        return new ResponseEntity<>(questionIds,HttpStatus.OK);
    }

    @PostMapping("getQuestionByIds")
    public ResponseEntity<List<QuestonDto>> getQuestionByIds(@RequestParam List<Long> questionIds){
        List<QuestonDto> questonDtos = new ArrayList<>();
        try {
            questonDtos = questionService.getQuestionByIds(questionIds);
        }catch (Exception ex){
            //log e
        }
        return new ResponseEntity<>(questonDtos,HttpStatus.OK);
    }

    @PostMapping("getMarks")
    public ResponseEntity<Integer> getMarks(@RequestBody List<ResponseDto> responseDtos){
        Integer marks = 0;
        try {
            marks = questionService.calCulateMarks(responseDtos);
        }catch (Exception ex){
            //log e
            return new ResponseEntity<>(-1,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(marks,HttpStatus.OK);
    }

}
