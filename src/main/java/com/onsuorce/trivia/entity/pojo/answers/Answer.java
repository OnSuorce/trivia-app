package com.onsuorce.trivia.entity.pojo.answers;

import com.onsuorce.trivia.enums.AnswerTypes;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;


@Data
public class Answer {
    @Getter
    private final AnswerTypes type;
    private Set<Option> options;

    public Answer(AnswerTypes type) {
        this.type = type;
    }


    public boolean validateAnswer(String guess){
        AtomicBoolean guessed = new AtomicBoolean(false);
        options.forEach(option -> {
            if(option.getCorrect() && option.getValue().equals(guess)){
            guessed.set(true);
            }
        });

        return guessed.get();
    }


}
