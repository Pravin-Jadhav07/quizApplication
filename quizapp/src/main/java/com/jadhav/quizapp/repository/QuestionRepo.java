package com.jadhav.quizapp.repository;

import com.jadhav.quizapp.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Long> {

    List<Question> findByCategory(String category);

    @NativeQuery("SELECT * FROM Question WHERE CATEGORY = :category ORDER BY RAND() LIMIT :numOfQuestions")
    List<Question> findRandomQuestionByCategory(String category, Long numOfQuestions);
}
