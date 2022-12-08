package com.onsuorce.trivia.exceptions;

public class QuestionSetException  extends Exception {

    public QuestionSetException(String msg, Throwable err){
        super(msg,err);
    }
    public QuestionSetException(String msg){
        super(msg);
    }
}
