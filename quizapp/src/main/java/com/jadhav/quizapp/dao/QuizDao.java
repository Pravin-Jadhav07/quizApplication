package com.jadhav.quizapp.dao;

import com.jadhav.quizapp.entity.Quiz;
import com.jadhav.quizapp.repository.QuizRepo;
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
