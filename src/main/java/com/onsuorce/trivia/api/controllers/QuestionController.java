package com.onsuorce.trivia.api.controllers;

import com.onsuorce.trivia.api.dto.AnswerDTO;
import com.onsuorce.trivia.api.dto.AnswerGuess;
import com.onsuorce.trivia.api.dto.QuestionCreationDTO;
import com.onsuorce.trivia.api.dto.QuestionDTO;
import com.onsuorce.trivia.entity.Question;
import com.onsuorce.trivia.service.QuestionService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/")
@Log4j2
@SuppressWarnings("unused")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping(path = "question/{uuid}")
    public Question getQuestion(@PathVariable String uuid) {
            return questionService.retrieveQuestion(UUID.fromString(uuid));
    }

    @PostMapping(path = "question/{uuid}/answer")
    public AnswerDTO getQuestionAnswer(@PathVariable String uuid, @RequestBody AnswerGuess answer){
        AnswerDTO a;
        Question q = questionService.retrieveQuestion(uuid);
        if(questionService.answerQuestion(q, answer.guess())){
            a = new AnswerDTO(true,q.getAnswer().getOptions(), q.getAnswer().getType());
        }else{
            a = new AnswerDTO(false, null, null);
        }

        return a;
    }

    @GetMapping(path = "questionset/{qs}/category/{categoryName}/questions")
    public List<QuestionDTO> getQuestions(@PathVariable String qs, @PathVariable String categoryName){
        return questionService.questionList(qs, categoryName).stream()
                .map( question -> new QuestionDTO(
                        question.getQuestionTitle(),
                        question.getCategory().getCategoryName(),
                        question.getUuid()))
                .collect(Collectors.toList());
    }


    @PostMapping(path = "question")
    public void postQuestion(@RequestBody QuestionCreationDTO body) {

        questionService.createNewQuestion(body.getQuestionTitle(), body.getAnswer(), body.getCategoryName(), body.getQuestionSet());
    }

    @PutMapping(path = "question/{uuid}")
    public void updateQuestion(@PathVariable String uuid, @RequestBody QuestionCreationDTO newQuestion){
        questionService.updateQuestion(uuid, newQuestion );
    }

    @DeleteMapping(path = "question/{uuid}")
    public void deleteQuestion(@PathVariable String uuid){
        questionService.deleteQuestion(uuid);
    }
}
