package com.opeoluwa.quiz.repository;

import com.opeoluwa.quiz.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String Category);


    List<Question> findByDifficultylevel(String difficultylevel);
}
