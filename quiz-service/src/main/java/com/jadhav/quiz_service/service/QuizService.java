package com.jadhav.quiz_service.service;

import com.jadhav.quiz_service.RestTemplate.QuestionServiceRest;
import com.jadhav.quiz_service.dao.QuizDao;
import com.jadhav.quiz_service.dto.QuestonDto;
import com.jadhav.quiz_service.dto.QuizWrapper;
import com.jadhav.quiz_service.dto.ResponseDto;
import com.jadhav.quiz_service.entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionServiceRest questionServiceRest;


    public void createQuiz(String category, Long numOfQuestions, String title) {
        List<Long> questionIds = questionServiceRest.getQuestionIdsForQuiz(category, numOfQuestions).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questionIds);
        quizDao.createQuiz(quiz);
    }

    public QuizWrapper getQuiz(Long id) {
        Quiz quiz = quizDao.getQuiz(id);
        List<Long> questionIds = quiz.getQuestionIds();
        List<QuestonDto> questionDtos = questionServiceRest.getQuestionByIds(questionIds).getBody();

        QuizWrapper quizWrapper = new QuizWrapper();
        quizWrapper.setId(quiz.getId());
        quizWrapper.setTitle(quiz.getTitle());
        quizWrapper.setQuestions(questionDtos);
        return quizWrapper;
    }

    public Integer calculateMarks(Long id, List<ResponseDto> responseDtos) {
        Integer marks = 0;
        marks = questionServiceRest.getMarks(responseDtos).getBody();
        return  marks;
    }
}
