package com.onsuorce.trivia.dao;

import com.onsuorce.trivia.entity.Category;
import com.onsuorce.trivia.entity.Question;
import com.onsuorce.trivia.enums.AnswerTypes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends MongoRepository<Question, String> {
    //TODO: Retrieve question by answertupe and category

    Optional<Question> findByUuid(String uuid);

    List<Question> findByCategory(Category category);

    @Query("{'answer.type' : '#answerType'}")
    List<Question> findByAnswerType(@Param("answerType") AnswerTypes answerType);



}
