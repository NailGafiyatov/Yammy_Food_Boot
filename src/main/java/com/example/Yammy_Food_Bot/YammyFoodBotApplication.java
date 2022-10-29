package com.example.Yammy_Food_Bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.Yammy_Food_Bot.service", "com.example.Yammy_Food_Bot.utils", "com.example.Yammy_Food_Bot.Controller"})
public class YammyFoodBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(YammyFoodBotApplication.class);
	}

}
