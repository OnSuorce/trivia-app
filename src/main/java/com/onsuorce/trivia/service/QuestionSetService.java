package com.onsuorce.trivia.service;

import com.onsuorce.trivia.dao.QuestionSetRepository;
import com.onsuorce.trivia.entity.QuestionSet;
import com.onsuorce.trivia.exceptions.QuestionSetException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class QuestionSetService {

    @Autowired
    QuestionSetRepository questionSetDao;

    //TODO: Create exception
    public void createQuestionSet(String name, String description) throws QuestionSetException {

        if(name == null || name.isEmpty() || getQuestionSet(name) != null){

            return;
        }

        questionSetDao.insert(
                QuestionSet.builder()
                        .setName(name)
                        .description(description)
                        .build()
        );
        log.info("Question set {} persisted", name);
    }

    private QuestionSet getQuestionSet(String qsName) throws QuestionSetException {
        QuestionSet qs = questionSetDao.findBySetName(qsName);
        if(qs == null){
            //TODO: Throw custom exception
            log.error("Error while retrieving question set with name: {}",qsName);
            throw new QuestionSetException("Question set doesn't exists");
        }
        return qs;
    }

    public QuestionSet retrieveQuestionSet(String qsName) throws QuestionSetException {
        return getQuestionSet(qsName);
    }

    public void updateQuestionSet(QuestionSet newQs) throws QuestionSetException {
        QuestionSet oldQs = getQuestionSet(newQs.getSetName());

    }

    public void deleteQuestionSet(QuestionSet qs) throws QuestionSetException {

        getQuestionSet(qs.getSetName());

        questionSetDao.delete(qs);
        log.info("Deleted {}",qs);
    }
}