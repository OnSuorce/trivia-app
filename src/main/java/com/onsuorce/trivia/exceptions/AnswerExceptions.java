package com.onsuorce.trivia.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class AnswerExceptions extends RuntimeException {

    public AnswerExceptions(String msg, Throwable err){
        super(msg,err);
    }
    public AnswerExceptions(String msg){
        super(msg);
    }
}