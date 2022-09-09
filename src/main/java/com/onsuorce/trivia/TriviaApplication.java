package com.onsuorce.trivia;

import com.onsuorce.trivia.dao.CategoryDao;
import com.onsuorce.trivia.dao.QuestionDao;
import com.onsuorce.trivia.entity.Category;
import com.onsuorce.trivia.entity.Question;
import com.onsuorce.trivia.entity.pojo.answers.BasicAnswer;
import com.onsuorce.trivia.enums.AnswerTypes;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
//TODO: Implement daos
@SpringBootApplication
public class TriviaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TriviaApplication.class, args);
	}


	@Bean
	CommandLineRunner runner(QuestionDao qdao, CategoryDao cdao){
		return  args -> {
			Category c = Category.builder()
					.name("General")
					.description("Generic questions")
					.build();
			cdao.insert(c);
			List<String> options = new ArrayList<>();
			options.add("2019");
			options.add("2021");
			BasicAnswer ba = BasicAnswer.builder()
					.answer("2022")
					.options(options)
					.build();

			Question q =  Question.builder()
					.questionTitle("What is the current year?")
					.answer(ba )
					.dateOfCreation(LocalDate.now())
					.category(c)
					.build();

			qdao.insert(q);
			System.out.println("SOSOSOOSOS");

		};

	}
}
