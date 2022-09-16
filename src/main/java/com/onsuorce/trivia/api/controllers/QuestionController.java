package com.onsuorce.trivia.api.controllers;

import com.onsuorce.trivia.api.dto.AnswerResponseDTO;
import com.onsuorce.trivia.api.dto.QuestionCreationDTO;
import com.onsuorce.trivia.entity.Question;
import com.onsuorce.trivia.entity.pojo.answers.Answer;
import com.onsuorce.trivia.enums.AnswerTypes;
import com.onsuorce.trivia.exceptions.QuestionException;
import com.onsuorce.trivia.service.QuestionService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("api/questions")
@Log4j2
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping(path = "/{uuid}")
    public Question getQuestion(@PathVariable String uuid, HttpServletResponse response) throws IOException {
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
            response.getWriter().print("Error \n"+ex);
            return null;

        }
    }

    @GetMapping(path = "/{uuid}",params = "answer")
    public AnswerResponseDTO getQuestion(@PathVariable String uuid, @Param("answer") String answer, HttpServletResponse response) throws IOException {

        try {

            log.info("Someone is trying to answer question {}", uuid);
            return questionService.answerQuestion(uuid, answer);

        } catch (QuestionException e) {
            log.error("Error with question. UUID: {} ; User input: {} ; Message: {}", uuid, answer, e.getMessage());
            response.setStatus(HttpStatus.NOT_FOUND.value());
            response.getWriter().print(e.getMessage());
            return null;

        }catch (Exception exception){
            return null;
        }

    }



    @PostMapping()
    public void postQuestion(@RequestBody QuestionCreationDTO body, HttpServletResponse response) throws IOException {
        try {

            Answer answer = new Answer(body.getAnswerValue(),AnswerTypes.valueOf(body.getAnswerType()));

            if( body.getOptions()!=null && !body.getOptions().isEmpty()){
                answer.setOptions(body.getOptions());
            }

            questionService.createNewQuestion(body.getQuestionTitle(), answer, body.getCategoryName());

        }catch (QuestionException qce){
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.getWriter().print("Error \n"+qce.getMessage());

        }

    }
}
