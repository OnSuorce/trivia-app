package com.onsuorce.trivia.api.controllers;

import com.onsuorce.trivia.api.dto.CategoryDTO;
import com.onsuorce.trivia.entity.Category;
import com.onsuorce.trivia.service.CategoryService;
import com.onsuorce.trivia.service.QuestionSetService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/{qs}/category")
@Log4j2
public class CategoryController {

    @Autowired
    CategoryService service;

    @Autowired
    QuestionSetService qsService;

    @GetMapping(path = "")
    public List<Category> getCategories(@PathVariable String qs){
        //TODO: Make better error handling
        return service.retrieveCategoryList(qsService.retrieveQuestionSet(qs));

    }

    @PostMapping()
    public void postCategory(@RequestBody CategoryDTO category){
        service.createCategory(category.getQuestionSet(), category.getCategoryName(), category.getDescription() );
    }


}
