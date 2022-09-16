package com.onsuorce.trivia.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class QuestionCreationDTO {

    private String questionTitle;
    private String categoryName;
    private String questionSet;
    private String answerValue;
    private String answerType;
    private List<String> options;


}
