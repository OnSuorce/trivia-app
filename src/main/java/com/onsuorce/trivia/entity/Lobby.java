package com.onsuorce.trivia.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Lobby {
    @Id
    private String id;
    private String name;
    private String hostUserId;
    private boolean isGameStarted;

    @DBRef
    private List<User> users;

    // Getters and setters...
}

