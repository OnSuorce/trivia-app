package com.onsuorce.trivia.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@Document("category")
@CompoundIndexes({
        @CompoundIndex(name = "questionSet_category_idx", def = "{'question_set': 1, 'category_name': 1}", unique = true)
})
public class Category {

    @Id
    private String id;

    @Field("category_name")
    private String categoryName;

    @DBRef
    @Field("question_set")
    private QuestionSet questionSet;

    private String description;
}
