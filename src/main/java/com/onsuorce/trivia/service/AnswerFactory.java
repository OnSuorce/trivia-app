package com.onsuorce.trivia.service;

import com.onsuorce.trivia.api.dto.AnswerDTO;
import com.onsuorce.trivia.entity.pojo.answers.Answer;

public class AnswerFactory {

    public static Answer instantiateAnswer(AnswerDTO dto){

       Answer a = new Answer(dto.getAnswerType());
       a.setOptions(dto.getOptions());

       return a;
    }


}
