package com.spring.helpDesk.Help_desk_backend;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HelpDeskBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelpDeskBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ChatClient.Builder builder) {
		return args -> {
			System.out.println("Application started");
		};
	}
}
