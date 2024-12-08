package com.jadhav.questionService.dao;


import com.jadhav.questionService.entity.Question;
import com.jadhav.questionService.repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestionDao {

    @Autowired
    QuestionRepo questionRepo;
    public void addOrUpdateQuestion(Question question) {
        questionRepo.save(question);
    }

    public void deleteQuestion(Long id) {
        questionRepo.deleteById(id);
    }

    public List<Question> getAllQuestions() {
        return questionRepo.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionRepo.findByCategory(category);
    }

    public List<Question> getRandomQuestionByCategory(String category, Long numOfQuestions) {
        return questionRepo.findRandomQuestionByCategory(category, numOfQuestions);
    }
}
