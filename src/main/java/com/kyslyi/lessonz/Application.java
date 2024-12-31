package com.kyslyi.lessonz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	@Bean
//	CommandLineRunner runner(LessonRepository lessonRepository) {
//		return args -> {
//			Lesson lesson = new Lesson(3, "Main method", "Java", LocalDateTime.now(), 60);
//			lessonRepository.create(lesson);
//		};
//	}
}
