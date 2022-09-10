package com.onsuorce.trivia;

import com.onsuorce.trivia.entity.Question;
import com.onsuorce.trivia.service.QuestionService;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class TriviaApplicationTests {

	@Autowired
	QuestionService questionService;
	@Test
	void contextLoads() {


	}

}
