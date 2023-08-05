package com.onsuorce.trivia.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Set Name already in use")
public class QuestionSetNameAlreadyUsedException extends RuntimeException {

    public QuestionSetNameAlreadyUsedException(String msg, Throwable err){
        super(msg,err);
    }
    public QuestionSetNameAlreadyUsedException(String msg){
        super(msg);
    }

    public QuestionSetNameAlreadyUsedException() {

    }
}
