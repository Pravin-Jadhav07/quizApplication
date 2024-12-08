package com.jadhav.quiz_service.RestTemplate;

import com.jadhav.quiz_service.dto.QuestonDto;
import com.jadhav.quiz_service.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTIONSERVICE")
public interface QuestionServiceRest {

    @PostMapping("question/getQuestionIds")
    ResponseEntity<List<Long>> getQuestionIdsForQuiz(@RequestParam String category, @RequestParam Long numOfQuestions);

    @PostMapping("question/getQuestionByIds")
    ResponseEntity<List<QuestonDto>> getQuestionByIds(@RequestParam List<Long> questionIds);

    @PostMapping("question/getMarks")
    ResponseEntity<Integer> getMarks(@RequestBody List<ResponseDto> responseDtos);

}
