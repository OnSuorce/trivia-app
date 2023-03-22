package com.onsuorce.trivia.api.controllers;

import com.onsuorce.trivia.api.dto.QuestionSetDTO;
import com.onsuorce.trivia.service.QuestionSetService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/questionset")
@Log4j2
@SuppressWarnings("unused")
public class QuestionSetController {

    @Autowired
    QuestionSetService service;

    @PostMapping()
    public void postQuestionSet(@RequestBody QuestionSetDTO body,  HttpServletResponse response){

            service.createQuestionSet(body.getSetName(), body.getDescription());
    }

    @GetMapping("/{name}")
    public QuestionSetDTO getQuestionSet(@PathVariable String name){
        return new QuestionSetDTO(service.retrieveQuestionSet(name));
    }

    @GetMapping()
    public List<QuestionSetDTO> getQuestionSetList(){
        return service.questionSetList().stream()
                .map( i -> new QuestionSetDTO(i.getSetName(),i.getDescription())).collect(Collectors.toList());
    }

    @DeleteMapping("/{name}")
    public void deleteQuestionSet(@PathVariable String name) {
        service.deleteQuestionSet(service.retrieveQuestionSet(name));

    }
}
