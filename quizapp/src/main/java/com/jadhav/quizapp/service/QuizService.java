package com.jadhav.quizapp.service;

import com.jadhav.quizapp.dao.QuestionDao;
import com.jadhav.quizapp.dao.QuizDao;
import com.jadhav.quizapp.dto.ResponseDto;
import com.jadhav.quizapp.entity.Question;
import com.jadhav.quizapp.entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;


    @Autowired
    QuestionDao questionDao;

    public void createQuiz(String category, Long numOfQuestions, String title) {
        List<Question> questions = questionDao.getRandomQuestionByCategory(category, numOfQuestions);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.createQuiz(quiz);
    }

    public Quiz getQuiz(Long id) {
        return quizDao.getQuiz(id);
    }

    public Integer calculateMarks(Long id, List<ResponseDto> responseDtos) {
        Integer marks = 0;
        Quiz quiz = quizDao.getQuiz(id);
        List<Question> questions = quiz.getQuestions();
        int i=0;
        for (ResponseDto responseDto : responseDtos) {
            if (responseDto.getAns().equals(questions.get(i).getAnswer())){
                marks++;
                i++;
            }
        }

        return  marks;
    }
}
