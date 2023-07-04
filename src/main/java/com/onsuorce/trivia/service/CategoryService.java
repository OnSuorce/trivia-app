package com.onsuorce.trivia.service;

import com.onsuorce.trivia.api.dto.CategoryDTO;
import com.onsuorce.trivia.dao.CategoryRepository;
import com.onsuorce.trivia.entity.Category;
import com.onsuorce.trivia.entity.QuestionSet;
import com.onsuorce.trivia.exceptions.Category.CategoryNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    QuestionSetService qsService;

    public void createCategory(String qsName, String categoryName,String description ){

        createCategory(qsService.retrieveQuestionSet(qsName), categoryName, description);
    }

    public void createCategory(QuestionSet qs, String categoryName, String description ){

        Category category = Category.builder()
                .questionSet(qs)
                .categoryName(categoryName)
                .description(description)
                .build();

        categoryRepository.save(category);

        log.info("{} Saved correctly", categoryName);
    }

    public Category retrieveCategory(String categoryName, QuestionSet qs){

        return categoryRepository.findByCategoryNameAndQuestionSet(categoryName,qs)
                .orElseThrow(() -> new CategoryNotFoundException(
                        "Category " +
                                categoryName +
                                " for questionSet " +
                                qs.getSetName() +
                                " not found"));
    }

    public List<Category> retrieveCategoryList(QuestionSet qs){

        return categoryRepository.findByQuestionSet(qs);
    }

    public void deleteCategory(Category category){

        categoryRepository.delete(category);
    }

    public void updateCategory(String qs, String categoryNameOld, CategoryDTO categoryNew){

        Category category = retrieveCategory(categoryNameOld,qsService.retrieveQuestionSet(qs));
        if(categoryNew.getCategoryName()!=null && !categoryNew.getCategoryName().isEmpty()){
            category.setCategoryName(categoryNew.getCategoryName());
        }

        if(categoryNew.getDescription()!=null && !categoryNew.getDescription().isEmpty()){
            category.setDescription(categoryNew.getDescription());
        }

        categoryRepository.save(category);

        log.info("Updated category {}", category);

    }
}
