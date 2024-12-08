package com.jadhav.quiz_service.controller;


import com.jadhav.quiz_service.dto.QuizWrapper;
import com.jadhav.quiz_service.dto.ResponseDto;
import com.jadhav.quiz_service.entity.Quiz;
import com.jadhav.quiz_service.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @GetMapping("greet")
    public ResponseEntity<String> greet(){
        return new ResponseEntity<>("Hii good morning..", HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam Long numOfQuestions, @RequestParam String title){
        String response;
        try {
            quizService.createQuiz(category,numOfQuestions,title);
            response = "sucess";
        }catch (Exception ex){
            //log ex
            response = "failed";
        }
        return  new ResponseEntity<>(response,HttpStatus.OK);

    }

    @GetMapping("get/{id}")
    public ResponseEntity<?> getQuiz(@PathVariable Long id){
        QuizWrapper quizWrapper;
        try {
            quizWrapper = quizService.getQuiz(id);
        }catch (Exception ex){
            //log
            return new ResponseEntity<>("not found",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(quizWrapper,HttpStatus.OK);
    }


    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Long id, @RequestBody List<ResponseDto> responseDtos){
        Integer marks = 0;
        try {
            marks = quizService.calculateMarks(id,responseDtos);
        }catch (Exception ex){
            // log
            return new ResponseEntity<>(marks,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(marks,HttpStatus.OK);
    }



}
