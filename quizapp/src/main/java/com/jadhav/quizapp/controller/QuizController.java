package com.jadhav.quizapp.controller;

import com.jadhav.quizapp.dto.ResponseDto;
import com.jadhav.quizapp.entity.Quiz;
import com.jadhav.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Stream;

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
        Quiz quiz = null;
        try {
            quiz = quizService.getQuiz(id);
        }catch (Exception ex){
            //log
            return new ResponseEntity<>("not found",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(quiz,HttpStatus.OK);
    }


    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Long id, @RequestBody List<ResponseDto> responseDtos){
        Integer marks = 0;
        try {
            marks = quizService.calculateMarks(id,responseDtos);
        }catch (Exception ex){
            // log
        }

        return new ResponseEntity<>(marks,HttpStatus.OK);
    }



}
