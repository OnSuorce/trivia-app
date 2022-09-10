package com.onsuorce.trivia.entity.pojo.answers;

import com.onsuorce.trivia.enums.AnswerTypes;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class Answer<T> {

    private final T value;
    private final AnswerTypes type;
    private List<T> options;

    public boolean validateAnswer(Answer guess){
        return guess.getValue().equals(value);
    }
}
