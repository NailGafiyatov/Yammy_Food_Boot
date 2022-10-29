package com.example.Yammy_Food_Boot.Controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@Log4j
public class UpdateController {
    private TelegramBot telegramBot;

    public void registerBot(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    public void processUpdate(Update update) {
        if (update == null) {
            log.error("Received update is null");
        }

        if (update.getMessage() != null) {
            distrubiteMessageByType(update);
        } else {
            log.error("Received unsupported message type " + update);
        }
    }

    private void distrubiteMessageByType(Update update) {
    }

    private void distributeMessageByType(Update update) {
        var message = update.getMessage();
        if (message.getText() != null) {
            processTextMessage(update);
        } else if (message.getDocument() != null) {
            processDocMessage(update);
        } else if (message.getPhoto() != null){
            processPhotoMessage(update);
        } else {
            setUnsupportedMessageTypeView(update);
        }
    }

    private void setUnsupportedMessageTypeView(Update update) {

    }

    private void processPhotoMessage(Update update) {

    }

    private void processTextMessage(Update update) {

    }

    private void processDocMessage(Update update) {

    }
}
