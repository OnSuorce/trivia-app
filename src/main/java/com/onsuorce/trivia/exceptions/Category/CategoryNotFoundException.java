package com.onsuorce.trivia.exceptions.Category;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Category does not exists")
public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException(String msg, Throwable err){
        super(msg,err);
    }
    public CategoryNotFoundException(String msg){
        super(msg);
    }

    public CategoryNotFoundException(){
        super();
    }
}
