package com.onsuorce.trivia.dao;

import com.onsuorce.trivia.entity.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionDao extends MongoRepository<Question, String> {
}
