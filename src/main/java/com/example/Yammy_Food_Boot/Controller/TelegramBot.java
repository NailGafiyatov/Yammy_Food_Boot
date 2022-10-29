package com.example.Yammy_Food_Boot.Controller;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Log4j
public class TelegramBot extends TelegramLongPollingBot {

    @Value("${bot.name}")
    private String botName;
    @Value("${bot.token}")
    private String botToken;
    private UpdateController updateController;

    public TelegramBot(UpdateController updateController) {
        this.updateController = updateController;
    }
@PostConstruct
    public void init() {
        updateController.registerBot(this);
    }

    @Override
    public String getBotUsername() {
        return botName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }



    private void sendWithoutURL(Message message) {
        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        InlineKeyboardButton button3 = new InlineKeyboardButton();
        InlineKeyboardButton button4 = new InlineKeyboardButton();

        button1.setText("Завтраки");
        button2.setText("Закуски");
        button3.setText("Основные блюда");
        button4.setText("Десерты");
        button1.setCallbackData("start1");
        button2.setCallbackData("start2");
        button3.setCallbackData("start3");
        button4.setCallbackData("start4");

        List<InlineKeyboardButton> keyboardButtonsRow = new ArrayList<>();
        keyboardButtonsRow.add(button1);
        keyboardButtonsRow.add(button2);
        keyboardButtonsRow.add(button3);
        keyboardButtonsRow.add(button4);

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow);

        keyboard.setKeyboard(rowList);

        try {
            execute(
                    SendMessage.
                            builder().
                            chatId(message.getChatId()).
                            parseMode("MarkDown").
                            text("Всем привет, я Марина \uD83E\uDEF6\uD83C\uDFFD\n" +
                                    "Готовлю \uD83E\uDDD1\uD83C\uDFFD\u200D\uD83C\uDF73 Делюсь рецептами. Обожаю тортики \uD83C\uDF82 и сыр\uD83E\uDDC0 Рецепты без заморочек❤️Придерживаюсь ПП на 80% от рациона питания\uD83D\uDCAA\uD83C\uDFFD\uD83E\uDD6C\uD83E\uDD24").
                            replyMarkup(keyboard).
                            build());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    private void sendKeyboardBreakfast(Message message) {
        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        InlineKeyboardButton button2 = new InlineKeyboardButton();

        button1.setText("Сладкие завтраки");
        button2.setText("Сытные завтраки");
        button1.setCallbackData("start1");
        button2.setCallbackData("start2");

        List<InlineKeyboardButton> keyboardButtonsRow = new ArrayList<>();
        keyboardButtonsRow.add(button1);
        keyboardButtonsRow.add(button2);

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow);

        keyboard.setKeyboard(rowList);

        try {
            execute(
                    SendMessage.
                            builder().
                            chatId(message.getChatId()).
                            parseMode("MarkDown").
                            text("Всем привет, я Марина \uD83E\uDEF6\uD83C\uDFFD\n" +
                                    "Готовлю \uD83E\uDDD1\uD83C\uDFFD\u200D\uD83C\uDF73 Делюсь рецептами. Обожаю тортики \uD83C\uDF82 и сыр\uD83E\uDDC0 Рецепты без заморочек❤️Придерживаюсь ПП на 80% от рациона питания\uD83D\uDCAA\uD83C\uDFFD\uD83E\uDD6C\uD83E\uDD24").
                            replyMarkup(keyboard).
                            build());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            Message command = update.getMessage();
            long chatID = update.getMessage().getChatId();

            switch(messageText) {
                case "/start":
                    startAnswer(command);
                    break;
                default:
                    try {
                        execute(
                                SendMessage.
                                        builder().
                                        chatId(chatID).
                                        parseMode("MarkDown").
                                        text("Команда не найдена").
                                        build());
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        } else if(update.hasCallbackQuery()) {

            switch(update.getCallbackQuery().getData()) {
                case "start1":
                    try {
                        execute(
                                SendMessage.
                                        builder().
                                        chatId(update.getCallbackQuery().getMessage().getChatId()).
                                        parseMode("MarkDown").
                                        text("1...").
                                        build());
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                case "start2":
                    try {
                        execute(
                                SendMessage.
                                        builder().
                                        chatId(update.getCallbackQuery().getMessage().getChatId()).
                                        parseMode("MarkDown").
                                        text("2...").
                                        build());
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                case "start3":
                    try {
                        execute(
                                SendMessage.
                                        builder().
                                        chatId(update.getCallbackQuery().getMessage().getChatId()).
                                        parseMode("MarkDown").
                                        text("3...").
                                        build());
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;
                case "start4":
                    try {
                        execute(
                                SendMessage.
                                        builder().
                                        chatId(update.getCallbackQuery().getMessage().getChatId()).
                                        parseMode("MarkDown").
                                        text("4...").
                                        build());
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    break;

            }



            /*
            if (update.getCallbackQuery().getData().equals("start1")) {
                try {
                    execute(
                            SendMessage.
                                    builder().
                                    chatId(update.getCallbackQuery().getMessage().getChatId()).
                                    parseMode("MarkDown").
                                    text("Контент в процессе загрузки...").
                                    build());
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }

             */
        }
    }
    public void startAnswer(Message command) {
        sendWithoutURL(command);
    }

    public void sendAnswerMessage(SendMessage message) {
        if (message != null) {
            try {
                execute(message);
            } catch (TelegramApiException e) {
                log.error(e);
            }
        }
    }
}
