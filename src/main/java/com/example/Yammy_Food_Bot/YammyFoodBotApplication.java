package com.example.Yammy_Food_Bot;

import com.example.Yammy_Food_Bot.Controller.TelegramBot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication(scanBasePackages = {"com.example.Yammy_Food_Bot.service", "com.example.Yammy_Food_Bot.utils", "com.example.Yammy_Food_Bot.Controller"})
public class YammyFoodBotApplication {

	public static void main(String[] args) throws TelegramApiException {
		SpringApplication.run(YammyFoodBotApplication.class);
//		ConfigurableApplicationContext context = SpringApplication.run(YammyFoodBotApplication.class, args);
//		TelegramBot bot = (TelegramBot) context.getBean("telegramBot");
//		TelegramBotsApi telegramBot = new TelegramBotsApi(DefaultBotSession.class);
//		telegramBot.registerBot(bot);
	}

}
