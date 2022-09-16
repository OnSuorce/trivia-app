package com.onsuorce.trivia.exceptions;

public class AnswerExceptions extends Exception {

    public AnswerExceptions(String msg, Throwable err){
        super(msg,err);
    }
    public AnswerExceptions(String msg){
        super(msg);
    }
}