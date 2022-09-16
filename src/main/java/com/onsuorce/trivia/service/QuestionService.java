package com.onsuorce.trivia.service;

import com.onsuorce.trivia.api.dto.AnswerResponseDTO;
import com.onsuorce.trivia.dao.CategoryRepository;
import com.onsuorce.trivia.dao.QuestionRepository;
import com.onsuorce.trivia.entity.Category;
import com.onsuorce.trivia.entity.Question;
import com.onsuorce.trivia.entity.pojo.answers.Answer;
import com.onsuorce.trivia.exceptions.QuestionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;


@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionDao;

    @Autowired
    CategoryRepository categoryDao;
    public void createNewQuestion(String questionTitle,Answer answer,String categoryName)throws QuestionException {
        if(questionTitle == null || questionTitle.isEmpty() || questionTitle.isBlank()) throw new QuestionException("Question text cannot be empty");
        //TODO: Add answer checks logic
        if(answer.getType() == null) throw new QuestionException("Answer type not valid");

        Category category = categoryDao.findByCategoryName(categoryName);
        if(category==null) throw new QuestionException("Category not valid");

        Question question = Question.builder()
                .questionTitle(questionTitle)
                .answer(answer)
                .category(category)
                .build();

        createNewQuestion(question);

    }
    private void createNewQuestion(Question question){

        question.setUuid(UUID.randomUUID().toString());
        question.setDateOfCreation(LocalDate.now());
        questionDao.insert(question);

    }

    public AnswerResponseDTO answerQuestion(String questionUuid, String answer) throws QuestionException{
        Question question = retrieveQuestion(questionUuid);
        if(question == null) throw new QuestionException("Question not found. UUID may incorrect");

        AnswerResponseDTO result = new AnswerResponseDTO();
        result.setMatched(false);
        if(question.getAnswer().validateAnswer(answer)){
            result.setAnswerValue(question.getAnswer().getValue());
            result.setMatched(true);
        }
        result.setGuess(answer);
        result.setPoints(0.0);

        return result;
    }

    public Question retrieveQuestion(UUID uuid){
        return questionDao.findByUuid(uuid.toString());
    }

    public Question retrieveQuestion(String uuid){
        return retrieveQuestion(UUID.fromString(uuid));
    }


}
