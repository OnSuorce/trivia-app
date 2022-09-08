package com.onsuorce.trivia.service;

import com.onsuorce.trivia.dao.QuestionDao;
import com.onsuorce.trivia.entity.Category;
import com.onsuorce.trivia.entity.Question;
import com.onsuorce.trivia.entity.pojo.answers.Answer;
import com.onsuorce.trivia.exceptions.QuestionCreationException;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;


@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;
    public void createNewQuestion(String questionTitle,Answer answer,String categoryId)throws QuestionCreationException{
        if(questionTitle == null) throw new QuestionCreationException("Question text cannot be empty");

    }
    private void createNewQuestion(Question question) throws QuestionCreationException{


        question.setUuid(UUID.randomUUID());
        question.setDateOfCreation(LocalDate.now());
        questionDao.insert(question);

    }

    public void answerQuestion(Question question, Object answer){
        question.getAnswer().validateAnswer(answer);
    }

    public Question retrieveQuestion(){
        return null;
    }


}
