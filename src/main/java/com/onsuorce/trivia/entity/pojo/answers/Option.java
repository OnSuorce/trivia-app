package com.onsuorce.trivia.entity.pojo.answers;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data
@AllArgsConstructor
public class Option {

    private String value;
    private Double points;

    private Boolean correct;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Option option = (Option) o;
        return Objects.equals(value, option.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
