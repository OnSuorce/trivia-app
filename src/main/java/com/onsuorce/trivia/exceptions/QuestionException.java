package com.onsuorce.trivia.exceptions;

public class QuestionException extends Exception {

    public QuestionException(String msg, Throwable err){
        super(msg,err);
    }
    public QuestionException(String msg){
        super(msg);
    }
}
