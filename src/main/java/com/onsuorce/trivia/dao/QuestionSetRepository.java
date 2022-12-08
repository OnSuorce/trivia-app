package com.onsuorce.trivia.dao;

import com.onsuorce.trivia.entity.Category;
import com.onsuorce.trivia.entity.QuestionSet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionSetRepository extends MongoRepository<QuestionSet, String> {

    QuestionSet findBySetName(String setName);
}
