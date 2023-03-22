package com.onsuorce.trivia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TriviaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TriviaApplication.class, args);
	}


/*	@Bean
	CommandLineRunner runner(QuestionDao qdao, CategoryDao cdao){
		return  args -> {
			Category c = Category.builder()
					.name("General")
					.description("Generic questions")
					.build();
			cdao.insert(c);
			List<String> options = new ArrayList<String>();
			options.add("2019");
			options.add("2021");
			Answer<String> a = new Answer<String>("2022", AnswerTypes.BASIC);
			a.setOptions(options);


			Question q =  Question.builder()
					.questionTitle("What is the current year?")
					.answer(a)
					.dateOfCreation(LocalDate.now())
					.category(c)
					.build();

			qdao.insert(q);
			System.out.println("SOSOSOOSOS");

		};

	}*/
}
