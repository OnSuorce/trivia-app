package com.onsuorce.trivia.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@Document("question_set")
public class QuestionSet {
    @Id
    private String id;

    @Indexed(unique = true)
    @Field("set_name")
    private String setName;

    private String description;
}
