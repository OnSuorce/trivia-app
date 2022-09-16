package com.onsuorce.trivia.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AnswerResponseDTO {

    private String guess;
    private Boolean matched;
    private Double points;
    private String answerValue;
}
