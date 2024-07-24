package com.pettelegram.project.listener;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import com.pettelegram.project.model.AdoptiveParent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelegramBotUpdatesListener implements UpdatesListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(TelegramBotUpdatesListener.class);

    private final TelegramBot telegramBot;

    public TelegramBotUpdatesListener(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    @Override
    public int process(List<Update> updates) {
        AdoptiveParent adoptiveParent = new AdoptiveParent(1L, "a", "b", "nick", 0);

        updates.forEach(update -> {
            LOGGER.info("Processing update: {}", update);
            if (update.message() != null) {
                String messageText = update.message().text();

                if (messageText.equals("/start")) { // send greeting message
                    telegramBot.execute(new SendMessage(update.message().chat().id(),
                            "Приветствую! Я бот, помогаю взаимодействовать с приютами для собачек!"));
                    telegramBot.execute(new SendMessage(update.message().chat().id(),
                            "Какой у вас вопрос?"));
                }

                if(adoptiveParent.getAdoptionStatus()==0) {
                    knowInfoAboutShelter();
                }
                else if(adoptiveParent.getAdoptionStatus()==1){
                    printInstructionsAboutPetFromShelter();
                }
                else if(adoptiveParent.getAdoptionStatus()==2){
                    getPetReport();
                }
                else {
                    callVolunteer();
                }
            }
        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }

    private void knowInfoAboutShelter(){ // здесь этап 1

    }
    private void printInstructionsAboutPetFromShelter(){ // здесь этап 2

    }
    private void getPetReport(){ // здесь этап 3

    }
    private void callVolunteer(){ // позвать волонтёра

    }

}
