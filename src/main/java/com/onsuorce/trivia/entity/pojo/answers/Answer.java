package com.onsuorce.trivia.entity.pojo.answers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.onsuorce.trivia.enums.AnswerTypes;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class Answer {

    @JsonIgnore
    private final String value;
    private final AnswerTypes type;
    private List<String> options;

    public boolean validateAnswer(Answer guess){
        return guess.getValue().equals(value);
    }

    public boolean validateAnswer(String guess){
        return guess.equals(value);
    }
}
