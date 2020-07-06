package com.cengiz.study;

import com.cengiz.study.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing

public class StudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyApplication.class, args);
	}

	@Bean
	@Autowired
	public CommandLineRunner loadData(QuestionRepository questionRepository) {
		return (args) -> {
			DataLoader dataLoader = new DataLoader(questionRepository);
			dataLoader.createData();
		};
	}
}
