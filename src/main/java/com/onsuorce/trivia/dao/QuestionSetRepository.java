package com.onsuorce.trivia.dao;

import com.onsuorce.trivia.entity.Category;
import com.onsuorce.trivia.entity.QuestionSet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionSetRepository extends MongoRepository<QuestionSet, String> {

    Optional<QuestionSet> findBySetName(String setName);
}
