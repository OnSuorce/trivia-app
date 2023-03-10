package com.onsuorce.trivia.api.controllers;

import com.onsuorce.trivia.api.dto.QuestionSetDTO;
import com.onsuorce.trivia.exceptions.QuestionSetException;
import com.onsuorce.trivia.service.QuestionSetService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("api/questionset")
@Log4j2
public class QuestionSetController {

    @Autowired
    QuestionSetService service;

    @PostMapping()
    public void postQuestionSet(@RequestBody QuestionSetDTO body,  HttpServletResponse response) throws IOException {
        try {

            service.createQuestionSet(body.getSetName(), body.getDescription());

        } catch (QuestionSetException e) {
            response.setStatus((HttpStatus.BAD_REQUEST.value()));
            response.getWriter().print(e.getMessage());
        }
    }

    @GetMapping("/{name}")
    public QuestionSetDTO getQuestionSet(@PathVariable String name,HttpServletResponse response) throws IOException {
        QuestionSetDTO  responseDto = null;
        try {

            responseDto = new QuestionSetDTO(service.retrieveQuestionSet(name));
            if (responseDto == null) throw new NullPointerException("Question set doesn't exist");
        }catch (NullPointerException e){

            response.setStatus((HttpStatus.NOT_FOUND.value()));
            response.getWriter().print(e.getMessage());
        }
        return responseDto;
    }

    @DeleteMapping("/{name}")
    public void deleteQuestionSet(@PathVariable String name,HttpServletResponse response) throws IOException{

        try {
            service.deleteQuestionSet(service.retrieveQuestionSet(name));
        } catch (QuestionSetException e) {

            response.setStatus((HttpStatus.NOT_FOUND.value()));
            response.getWriter().print(e.getMessage());
        }
    }
}
