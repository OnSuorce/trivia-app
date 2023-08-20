package com.onsuorce.trivia.service;

import com.onsuorce.trivia.api.dto.AnswerDTO;
import com.onsuorce.trivia.api.dto.QuestionCreationDTO;
import com.onsuorce.trivia.dao.QuestionRepository;
import com.onsuorce.trivia.entity.Category;
import com.onsuorce.trivia.entity.Question;
import com.onsuorce.trivia.entity.pojo.answers.Answer;
import com.onsuorce.trivia.entity.pojo.answers.Option;
import com.onsuorce.trivia.enums.AnswerTypes;
import com.onsuorce.trivia.exceptions.AnswerExceptions;
import com.onsuorce.trivia.exceptions.QuestionException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Log4j2
@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionDao;

    @Autowired
    CategoryService categoryService;

    @Autowired
    QuestionSetService questionSetService;
    public void createNewQuestion(String questionTitle,AnswerDTO answer,String categoryName, String qs) {
        if(questionTitle == null || questionTitle.isEmpty() || questionTitle.isBlank()) throw new QuestionException("Question text cannot be empty");

        Category category = categoryService.retrieveCategory(categoryName, questionSetService.retrieveQuestionSet(qs));

        validateAnswer(answer);

        Question question;
        try {
            question = Question.builder()
                    .questionTitle(questionTitle)
                    .answer(AnswerFactory.instantiateAnswer(answer))
                    .category(category)
                    .dateOfCreation(LocalDate.now())
                    .build();

        } catch (Exception e) {
            throw new AnswerExceptions(e.getMessage());
        }
        createNewQuestion(question);
    }

    private void validateAnswer(AnswerDTO answer) {
        if(answer.getOptions()==null || answer.getOptions().isEmpty()){
            throw new AnswerExceptions("At least 1 option must be provided");
        }


        
        Option correctOption = null;
        for (Option o:answer.getOptions()) {
            if(o.getCorrect()){
                if(correctOption!=null){
                    throw new AnswerExceptions("Multiple correct options are not supported");
                }
                correctOption = o;
                

            }
        }

        if(correctOption==null){
            throw new AnswerExceptions("There must be 1 correct option");
        }

    }


    public List<Question> questionList(String qs, String category){

        return questionDao.findByCategory(
                categoryService.retrieveCategory(category,
                        questionSetService.retrieveQuestionSet(qs))
        );

    }
    private void createNewQuestion(Question question){

        question.setUuid(UUID.randomUUID().toString());
        question.setDateOfCreation(LocalDate.now());
        questionDao.insert(question);

    }

    public boolean answerQuestion(String questionUuid, String guess) throws QuestionException{

        Question question = retrieveQuestion(questionUuid);
        return answerQuestion(question, guess);
    }

    public boolean answerQuestion(Question question, String guess) throws QuestionException{

        return question.getAnswer().validateAnswer(guess);

    }

    public Question retrieveQuestion(UUID uuid){
        return questionDao.findByUuid(uuid.toString()).orElseThrow(QuestionException::new);
    }

    public Question retrieveQuestion(String uuid){
        return retrieveQuestion(UUID.fromString(uuid));
    }

    public void updateQuestion(String uuidOldQuestion, QuestionCreationDTO newQuestion){

        Question oldQuestion = retrieveQuestion(uuidOldQuestion);

        if(newQuestion.getQuestionTitle() != null && !newQuestion.getQuestionTitle().isEmpty() ){

            oldQuestion.setQuestionTitle(newQuestion.getQuestionTitle());
        }

       /* if(newQuestion.getCategoryName() != null && !newQuestion.getCategoryName().isEmpty() ){

            oldQuestion.setCategory(categoryService.retrieveCategory(newQuestion.getCategoryName(),oldQuestion.getCategory().getQuestionSet()));
        }*/

        if(newQuestion.getAnswer() != null ){
            oldQuestion.setAnswer(
                    new Answer(newQuestion.getAnswer().getAnswerType()==null ?
                            oldQuestion.getAnswer().getType() : newQuestion.getAnswer().getAnswerType()));
            if (newQuestion.getAnswer().getOptions() != null && !newQuestion.getAnswer().getOptions().isEmpty()){
                oldQuestion.getAnswer().setOptions(newQuestion.getAnswer().getOptions());
            }

        }

        questionDao.save(oldQuestion);
    }

    public void deleteQuestion(String uuid){
        questionDao.delete(retrieveQuestion(uuid));
    }

    public List<String> retrieveAnswerTypes() {
        return Arrays.stream(AnswerTypes.values()).map(AnswerTypes::toString)
                .collect(Collectors.toList());

    }
}
