package com.onsuorce.trivia.exceptions;

public class QuestionCreationException extends Exception {

    public QuestionCreationException(String msg,Throwable err){
        super(msg,err);
    }
    public QuestionCreationException(String msg){
        super(msg);
    }
}
