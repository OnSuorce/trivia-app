package com.onsuorce.trivia.api.controllers;

import com.onsuorce.trivia.api.dto.CategoryDTO;
import com.onsuorce.trivia.entity.Category;
import com.onsuorce.trivia.service.CategoryService;
import com.onsuorce.trivia.service.QuestionSetService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/{qs}/category")
@Log4j2
@SuppressWarnings("unused")
public class CategoryController {
    @Autowired
    CategoryService service;
    @Autowired
    QuestionSetService qsService;

    @GetMapping(path = "")
    public List<CategoryDTO> getCategoryList(@PathVariable String qs){
        //TODO: Make better error handling

        return service.retrieveCategoryList(qsService.retrieveQuestionSet(qs)).stream().map(this::categoryToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/{categoryName}")
    public CategoryDTO getCategory(@PathVariable String qs, @PathVariable String categoryName){
        Category category = service.retrieveCategory(categoryName, qsService.retrieveQuestionSet(qs));
        return categoryToDTO(category);
    }

    @DeleteMapping(path = "/{categoryName}")
    public void deleteCategory(@PathVariable String qs, @PathVariable String categoryName){
        service.deleteCategory(service.retrieveCategory(categoryName, qsService.retrieveQuestionSet(qs)));
    }

    @PutMapping(path = "/{categoryName}")
    public void updateCategory(@PathVariable String qs,@PathVariable String categoryName, @RequestBody CategoryDTO category){

    }
    @PostMapping()
    public void postCategory(@RequestBody CategoryDTO category){
        service.createCategory(category.getQuestionSet(), category.getCategoryName(), category.getDescription() );
    }

    private CategoryDTO categoryToDTO(Category c){
        return CategoryDTO.builder()
                .questionSet(c.getQuestionSet().getSetName())
                .categoryName(c.getCategoryName())
                .description(c.getDescription())
                .build();
    }

}
