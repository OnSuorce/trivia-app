package com.onsuorce.trivia.api.dto;

import com.onsuorce.trivia.entity.QuestionSet;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@ToString
public class QuestionSetDTO {

    public QuestionSetDTO(QuestionSet set){
        setName = set.getSetName();
        description = set.getDescription();
    }
    private String setName;

    private String description;


}
