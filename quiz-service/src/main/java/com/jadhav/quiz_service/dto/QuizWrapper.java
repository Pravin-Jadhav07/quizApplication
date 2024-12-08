package com.jadhav.quiz_service.dto;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuizWrapper {

    private Long id;
    private String title;
    private List<QuestonDto> questions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<QuestonDto> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestonDto> questions) {
        this.questions = questions;
    }
}
