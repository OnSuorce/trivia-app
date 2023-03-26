package com.onsuorce.trivia.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "QuestionSet not Found")
public class QuestionSetException  extends RuntimeException {

    public QuestionSetException(String msg, Throwable err){
        super(msg,err);
    }
    public QuestionSetException(String msg){
        super(msg);
    }

    public QuestionSetException() {

    }
}
