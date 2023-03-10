package com.onsuorce.trivia.dao;

import com.onsuorce.trivia.entity.Category;
import com.onsuorce.trivia.entity.QuestionSet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {

    Category findByCategoryName(String categoryName);

    Category findByCategoryNameAndQuestionSet(String categoryName, QuestionSet qs);
    List<Category> findByQuestionSet(QuestionSet qs);
}
