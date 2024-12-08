package com.jadhav.quiz_service.dao;


import com.jadhav.quiz_service.entity.Quiz;
import com.jadhav.quiz_service.repository.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuizDao {

    @Autowired
    QuizRepo quizRepo;

    public void createQuiz(Quiz quiz) {
        quizRepo.save(quiz);
    }

    public Quiz getQuiz(Long id) {
        return quizRepo.findById(id).get();
    }
}
