package com.onsuorce.trivia.entity.pojo.answers;


import com.onsuorce.trivia.enums.AnswerTypes;
import lombok.Builder;
import java.util.List;

public class BasicAnswer extends Answer<String> {

    private final AnswerTypes type = AnswerTypes.BASIC;

    @Builder
    public BasicAnswer(String answer, List<String> options) {
        super.setAnswer(answer);
        super.setOptions(options);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        BasicAnswer that = (BasicAnswer) o;

       if (!that.getAnswer().equals(super.getAnswer())) return false;

       if (!that.getOptions().equals(super.getOptions())) return false;

        return type == that.type;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }
}
