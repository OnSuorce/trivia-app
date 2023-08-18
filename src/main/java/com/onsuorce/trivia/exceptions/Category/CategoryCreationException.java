package com.onsuorce.trivia.exceptions.Category;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Duplicated category")
public class CategoryCreationException extends RuntimeException{
    public CategoryCreationException(String msg) {
        super(msg);
    }
}
