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
@Document("category")
public class Category {

    @Id
    private String id;

    @Field("category_name")
    private String categoryName;

    @Indexed(unique = true)
    private String questionSet;

    private String description;
}
