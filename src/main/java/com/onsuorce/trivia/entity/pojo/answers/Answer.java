package com.onsuorce.trivia.entity.pojo.answers;

import com.onsuorce.trivia.enums.AnswerTypes;
import lombok.Data;

import java.util.List;

@Data
public abstract class Answer<T> {

    private T value;
    private AnswerTypes type;
    private List<String> options;

    public boolean validateAnswer(T guess){
        return guess.equals(value);
    }
}
