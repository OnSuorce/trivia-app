package com.onsuorce.trivia.dao;

import com.onsuorce.trivia.entity.Question;
import com.onsuorce.trivia.enums.AnswerTypes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends MongoRepository<Question, String> {
    //TODO: Retrieve question by answertupe and category

    Question findByUuid(String uuid);

    List<Question> findByCategory(String category);

    @Query("{'answer.type' : '#answerType'}")
    List<Question> findByAnswerType(@Param("answerType") AnswerTypes answerType);



}
