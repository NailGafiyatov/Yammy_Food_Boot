package com.example.Yammy_Food_Boot;

import com.example.Yammy_Food_Boot.Controller.TelegramBot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class YammyFoodBootApplication {

	public static void main(String[] args) throws TelegramApiException {
		ConfigurableApplicationContext context = SpringApplication.run(YammyFoodBootApplication.class, args);
		TelegramBot bot = (TelegramBot) context.getBean("telegramBot");
		System.out.println(bot.getBotToken() + "-" + bot.getBotUsername());
		TelegramBotsApi telegramBot = new TelegramBotsApi(DefaultBotSession.class);
		telegramBot.registerBot(bot);
	}

}
