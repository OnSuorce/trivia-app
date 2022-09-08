package com.onsuorce.trivia.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document("category")
public class Category {

    @Id
    private String id;

    @NonNull
    private String name;

    private String description;
}
