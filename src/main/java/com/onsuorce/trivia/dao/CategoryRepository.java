package com.onsuorce.trivia.dao;

import com.onsuorce.trivia.entity.Category;
import com.onsuorce.trivia.entity.QuestionSet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {

    Optional<Category> findByCategoryName(String categoryName);

   Optional<Category> findByCategoryNameAndQuestionSet(String categoryName, QuestionSet qs);
    List<Category> findByQuestionSet(QuestionSet qs);
}
