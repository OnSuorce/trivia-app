package com.onsuorce.trivia.entity;

import com.onsuorce.trivia.entity.pojo.answers.Answer;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder(access = AccessLevel.PUBLIC)
@Document("question")

public class Question {

    @Id
    private String id;

    private String questionTitle;
    private Answer answer;

    @Indexed(unique = true)
    private String uuid;

    @DBRef
    private Category  category;
    private LocalDate dateOfCreation;

    @Override
    public String toString() {
        return "Question{" +
                "question='" + questionTitle + '\'' +
                ", answer='" + answer + '\'' +
                ", dateOfCreation=" + dateOfCreation +
                '}';
    }
}
