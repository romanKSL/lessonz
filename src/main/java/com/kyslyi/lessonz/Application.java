package com.kyslyi.lessonz;

import com.kyslyi.lessonz.lesson.LessonRepository;
import com.kyslyi.lessonz.user.User;
import com.kyslyi.lessonz.user.UserRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner runner(UserRestClient client) {
		return args -> {
			List<User> users = client.findAll();
			System.out.println("Users: " + users);

		};
	}
}
