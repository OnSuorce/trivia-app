package com.onsuorce.trivia.api.controllers;

import com.onsuorce.trivia.api.dto.AnswerDTO;
import com.onsuorce.trivia.api.dto.AnswerGuess;
import com.onsuorce.trivia.api.dto.QuestionCreationDTO;
import com.onsuorce.trivia.api.dto.QuestionDTO;
import com.onsuorce.trivia.entity.Question;
import com.onsuorce.trivia.entity.pojo.answers.Option;
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

    @GetMapping(path = "question/{uuid}/detail")
    public Question getQuestion(@PathVariable String uuid) {
        return questionService.retrieveQuestion(UUID.fromString(uuid));

    }
    @GetMapping(path = "question/{uuid}")
    public QuestionDTO getQuestionDTO(@PathVariable String uuid) {
        return toQuestionDTO(questionService.retrieveQuestion(UUID.fromString(uuid)));
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

    @GetMapping(path = "question/")
    public List<QuestionDTO> getQuestions( @RequestParam("categoryName") String categoryName,  @RequestParam("questionSet") String questionSet){
        return questionService.questionList(questionSet, categoryName).stream()
                .map(this::toQuestionDTO)
                .collect(Collectors.toList());
    }

    private QuestionDTO toQuestionDTO(Question question){
        return new QuestionDTO(
                question.getQuestionTitle(),
                question.getCategory().getCategoryName(),
                question.getUuid(),
                question.getAnswer().getOptions().stream().map(Option::getValue).collect(Collectors.toSet()));
    }


    @PostMapping(path = "question/")
    public void postQuestion(@RequestBody QuestionCreationDTO body, @RequestParam("categoryName") String categoryName,  @RequestParam("questionSet") String questionSet) {
        questionService.createNewQuestion(body.getQuestionTitle(), body.getAnswer(), categoryName, questionSet);
    }

    @PutMapping(path = "question/{uuid}")
    public void updateQuestion(@PathVariable String uuid, @RequestBody QuestionCreationDTO newQuestion){
        questionService.updateQuestion(uuid, newQuestion );
    }

    @DeleteMapping(path = "question/{uuid}")
    public void deleteQuestion(@PathVariable String uuid){
        questionService.deleteQuestion(uuid);
    }

    @GetMapping(path = "question/types")
    public List<String> getQuestion() {
        return questionService.retrieveAnswerTypes();

    }
}
