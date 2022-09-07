package com.onsuorce.trivia.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Builder(access = AccessLevel.PUBLIC)
@Document("question")

public class Question {

    @Id
    private String id;
    private String question;
    private String answer;

    private Category  category;
    private LocalDate dateOfCreation;

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", dateOfCreation=" + dateOfCreation +
                '}';
    }
}
