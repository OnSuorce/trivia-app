package com.onsuorce.trivia.entity.pojo.answers;

import com.onsuorce.trivia.enums.AnswerTypes;
import lombok.Data;

@Data
public abstract class Answer<T> {

    private T answer;
    private AnswerTypes type;

    public boolean validateAnswer(T guess){
        return guess.equals(answer);
    }
}
