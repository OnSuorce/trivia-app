package com.onsuorce.trivia.service;

import com.onsuorce.trivia.dao.QuestionSetRepository;
import com.onsuorce.trivia.entity.QuestionSet;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class QuestionSetService {

    @Autowired
    QuestionSetRepository questionSetDao;

    //TODO: Create exception
    public void createQuestionSet(String name, String description){

        if(name == null || name.isEmpty() || name.isEmpty() || questionSetDao.findBySetName(name) != null){
            log.error("Could not persist question set");
            return;
        }

        questionSetDao.insert(
                QuestionSet.builder()
                        .setName(name)
                        .description(description)
                        .build()
        );
        log.info("Question set persisted");
    }
}

//TODO: Delete
//TODO: Update