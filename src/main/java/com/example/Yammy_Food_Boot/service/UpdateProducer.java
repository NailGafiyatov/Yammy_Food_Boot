package com.example.Yammy_Food_Boot.service;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface UpdateProducer {
    void producer(String rabbitQueue, Update update);
}
