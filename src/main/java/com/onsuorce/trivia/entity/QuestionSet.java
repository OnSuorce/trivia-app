package com.onsuorce.trivia.entity;

//TODO: Build this document

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document("question_set")
public class QuestionSet {
    @Id
    private String id;

    @NonNull
    private String name;

    @NonNull
    private String description;
}
