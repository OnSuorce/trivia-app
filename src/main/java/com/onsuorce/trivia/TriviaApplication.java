package com.onsuorce.trivia;

import com.onsuorce.trivia.dao.CategoryDao;
import com.onsuorce.trivia.dao.QuestionDao;
import com.onsuorce.trivia.entity.Category;
import com.onsuorce.trivia.entity.Question;
import com.onsuorce.trivia.enums.AnswerTypes;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

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

			Question q =  Question.builder()
					.question("What is the current year?")
					.answer("2022")
					.dateOfCreation(LocalDate.now())
					.category(c)
					.build();

			qdao.insert(q);
			System.out.println("SOSOSOOSOS");

		};

	}
}
