package com.onsuorce.trivia.service;

import com.onsuorce.trivia.dao.QuestionRepository;
import com.onsuorce.trivia.entity.Question;
import com.onsuorce.trivia.entity.pojo.answers.Answer;
import com.onsuorce.trivia.exceptions.QuestionCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;


@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionDao;
    public void createNewQuestion(String questionTitle,Answer<?> answer,String categoryId)throws QuestionCreationException{
        if(questionTitle == null || questionTitle.isEmpty() || questionTitle.isBlank()) throw new QuestionCreationException("Question text cannot be empty");
        //TODO: Add answer creation logic

        //TODO add category lookup

        Question question = Question.builder()
                .questionTitle(questionTitle)
                .category(null)
                .build();

        createNewQuestion(question);

    }
    private void createNewQuestion(Question question) throws QuestionCreationException{

        question.setUuid(UUID.randomUUID().toString());
        question.setDateOfCreation(LocalDate.now());
        questionDao.insert(question);

    }

    public void answerQuestion(Question question, Object answer){
        question.getAnswer().validateAnswer(answer);
    }

    public Question retrieveQuestion(UUID uuid){
        return questionDao.findByUuid(uuid.toString());
    }
        //TODO: Add implementation

}
