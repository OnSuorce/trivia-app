package com.onsuorce.trivia.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.onsuorce.trivia.entity.pojo.answers.Option;
import com.onsuorce.trivia.enums.AnswerTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnswerDTO {

    @JsonProperty("matched")
    private Boolean matched;

    @JsonProperty("options")
    private Set<Option> options;
    @JsonProperty("answer_type")
    private AnswerTypes answerType;



}
