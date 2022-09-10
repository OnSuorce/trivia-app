package com.onsuorce.trivia.api.controllers;

import com.onsuorce.trivia.entity.Question;
import com.onsuorce.trivia.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("api/questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping(params = "uuid")
    public Question getQuestion(@Param("uuid") String uuid, HttpServletResponse response) throws IOException {

        try {
            Question q = questionService.retrieveQuestion(UUID.fromString(uuid));
            if (q == null) throw new Exception();
            return q;
        }catch (IllegalArgumentException ex) {
            response.setStatus((HttpStatus.BAD_REQUEST.value()));
            response.getWriter().print("Invalid UUID");
            return null;
        }
        catch (Exception ex) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.getWriter().print("Suca \n"+ex);
            return null;

        }

    }
}
