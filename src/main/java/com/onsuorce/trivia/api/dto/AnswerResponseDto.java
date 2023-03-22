package com.onsuorce.trivia.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AnswerResponseDto {

    @JsonProperty("guess")
    private String guess;
    @JsonProperty("matched")
    private Boolean matched;
    @JsonProperty("points")
    private Double points;
}
