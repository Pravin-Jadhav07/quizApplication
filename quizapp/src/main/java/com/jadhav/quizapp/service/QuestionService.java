package com.jadhav.quizapp.service;

import com.jadhav.quizapp.dao.QuestionDao;
import com.jadhav.quizapp.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public void addOrUpdateQuestion(Question question) {
        questionDao.addOrUpdateQuestion(question);
    }

    public void deleteQuestion(Long id) {
        questionDao.deleteQuestion(id);
    }

    public List<Question> getAllQuestions() {
        return questionDao.getAllQuestions();
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionDao.getQuestionsByCategory(category);
    }
}
