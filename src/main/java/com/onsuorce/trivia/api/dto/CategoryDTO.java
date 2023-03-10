package com.onsuorce.trivia.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDTO {
    private String categoryName;
    private String questionSet;
    private String description;
}
