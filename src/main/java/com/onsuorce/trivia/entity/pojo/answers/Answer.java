package com.onsuorce.trivia.entity.pojo.answers;


import lombok.Data;
import java.util.List;

@Data
public abstract class Answer<T> {

    private T answer;
    private List<String> options;
    public boolean validateAnswer(T guess){
        return guess.equals(answer);
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answer=" + answer +
                '}';
    }
}
