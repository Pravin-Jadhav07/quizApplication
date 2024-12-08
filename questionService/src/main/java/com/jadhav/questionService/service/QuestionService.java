package com.jadhav.questionService.service;


import com.jadhav.questionService.dao.QuestionDao;
import com.jadhav.questionService.dto.QuestonDto;
import com.jadhav.questionService.dto.ResponseDto;
import com.jadhav.questionService.entity.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public  List<Long> getQuestionIdsForQuiz(String category, Long numOfQuestions) {
        return questionDao.getRandomQuestionByCategory(category, numOfQuestions);
    }

    public List<QuestonDto> getQuestionByIds(List<Long> questionIds) {
        List<Question>  questions = questionDao.getQuestionByIds(questionIds);
        List<QuestonDto> questonDtos = new ArrayList<>();

        for (Question question : questions) {
            QuestonDto questonDto= new QuestonDto();
            questonDto.setId(question.getId());
            questonDto.setQuestion(question.getQuestion());
            questonDto.setOption1(question.getOption1());
            questonDto.setOption2(question.getOption2());
            questonDto.setOption3(question.getOption3());
            questonDto.setOption4(question.getOption4());
            questonDtos.add(questonDto);
        }
        return questonDtos;
    }

    public Integer calCulateMarks(List<ResponseDto> responseDtos) {

        Integer marks = 0;
        for (ResponseDto responseDto : responseDtos) {
            String ans  = questionDao.getAnsById(responseDto.getId());
            if (responseDto.getAns().equals(ans))
                marks++;
        }
        return marks;
    }
}
