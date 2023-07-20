package com.onsuorce.trivia.api.dto;



import java.util.Set;

public record QuestionDTO(String questionTitle, String categoryName, String uuid, Set<String> optionList) {
}
