package com.onsuorce.trivia.api.dto;

import com.onsuorce.trivia.entity.pojo.answers.Answer;
import lombok.Data;

import java.util.List;

@Data
public class QuestionCreationDTO {

    private String questionTitle;
    private String categoryName;
    private String answerValue;
    private List<String> options;


}
