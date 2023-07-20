package com.onsuorce.trivia.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionCreationDTO {

    @JsonProperty("question_title")
    private String questionTitle;


    @JsonProperty("answer")
    private AnswerDTO answer;


}
