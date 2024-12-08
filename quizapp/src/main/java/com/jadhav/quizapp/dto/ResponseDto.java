package com.jadhav.quizapp.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
public class ResponseDto {
    private Long id;
    private String ans;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }
}
