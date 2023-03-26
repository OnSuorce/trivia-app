package com.onsuorce.trivia;

import com.onsuorce.trivia.dao.QuestionSetRepository;
import com.onsuorce.trivia.entity.QuestionSet;
import com.onsuorce.trivia.exceptions.QuestionSetException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DataMongoTest
@ExtendWith(SpringExtension.class)
class TriviaApplicationTests {

    @Autowired
    QuestionSetRepository questionSetRepository;
    @Test()
    public void testFind() {

        QuestionSet qs = questionSetRepository.findBySetName("Test").orElseThrow(QuestionSetException::new);

        assertEquals("Test", qs.getSetName());
    }

}
