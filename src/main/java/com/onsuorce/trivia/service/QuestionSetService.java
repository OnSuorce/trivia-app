package com.onsuorce.trivia.service;

import com.onsuorce.trivia.dao.QuestionSetRepository;
import com.onsuorce.trivia.entity.QuestionSet;
import com.onsuorce.trivia.exceptions.QuestionSetException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class QuestionSetService {

    @Autowired
    QuestionSetRepository questionSetDao;


    public void createQuestionSet(String name, String description) throws QuestionSetException {

        if(name == null || name.isEmpty()){
            throw new QuestionSetException("Name cannot be null");
        }

        if(getQuestionSet(name) != null){
            throw new QuestionSetException("Name is already in use");
        }

        questionSetDao.insert(
                QuestionSet.builder()
                        .setName(name)
                        .description(description)
                        .build()
        );
        log.info("Question set {} persisted", name);
    }

    private QuestionSet getQuestionSet(String qsName) {
       return questionSetDao.findBySetName(qsName)
               .orElseThrow(() -> new QuestionSetException("Question set not found for: "+qsName));
    }

    public QuestionSet retrieveQuestionSet(String qsName) {
        return getQuestionSet(qsName);
    }

    public List<QuestionSet> questionSetList(){
        return questionSetDao.findAll();
    }
    public void updateQuestionSet(QuestionSet newQs) throws QuestionSetException {
        QuestionSet oldQs = getQuestionSet(newQs.getSetName());
        oldQs.setDescription(newQs.getDescription());
        questionSetDao.save(oldQs);
        log.info("Question set {} updated",oldQs.getSetName());

    }

    public void deleteQuestionSet(QuestionSet qs) throws QuestionSetException {

        getQuestionSet(qs.getSetName());

        questionSetDao.delete(qs);
        log.info("Deleted {}",qs);
    }
}