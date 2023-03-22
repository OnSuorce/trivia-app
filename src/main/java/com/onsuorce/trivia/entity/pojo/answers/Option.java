package com.onsuorce.trivia.entity.pojo.answers;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Option {

    private String value;
    private Double points;

    private Boolean correct;

}
