package com.onsuorce.trivia.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Question not Found")
public class QuestionException extends RuntimeException {

    public QuestionException(String msg, Throwable err){
        super(msg,err);
    }
    public QuestionException(String msg){
        super(msg);
    }

    public QuestionException() {

    }
}
