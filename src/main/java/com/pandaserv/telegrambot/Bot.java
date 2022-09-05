package com.pandaserv.telegrambot;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class Bot extends TelegramLongPollingBot {

    //создаем две константы, присваиваем им значения токена и имя бота соответсвтенно
    //вместо звездочек подставляйте свои данные
    final private String BOT_TOKEN = "5070270430:AAGJCJtpis2GrtTI0de5G3nPspdpkfVNeGw";
    final private String BOT_NAME = "PandA_win_admin_bot";

    Storage storage;

    public Bot(Storage storage) {
       this.storage = storage;
    }


    private String tempChatId = "425222583";


    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        try{
            if(update.hasMessage() && update.getMessage().hasText())
            {
                //Извлекаем из объекта сообщение пользователя
                Message inMess = update.getMessage();
                //Достаем из inMess id чата пользователя
                String chatId = inMess.getChatId().toString();
                System.out.println(chatId);
                tempChatId = chatId;
                //Получаем текст сообщения пользователя, отправляем в написанный нами обработчик
                String response = parseMessage(inMess.getText());
                //Создаем объект класса SendMessage - наш будущий ответ пользователю
                SendMessage outMess = new SendMessage();

                //Добавляем в наше сообщение id чата а также наш ответ
                outMess.setChatId(chatId);
                outMess.setText(response);

                //Отправка в чат
                execute(outMess);
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public String parseMessage(String textMsg) {
        String response;

        //Сравниваем текст пользователя с нашими командами, на основе этого формируем ответ
        if(textMsg.equals("/start"))
            response = "Приветствую, бот знает много цитат. Жми /get, чтобы получить случайную из них";
        else if(textMsg.equals("/get"))
            response = storage.getRandQuote();
        else
            response = "Сообщение не распознано";

        return response;
    }

    public void sendMessage(String input){
        if(!"".equals(tempChatId)){
            SendMessage outMess = new SendMessage();

            //Добавляем в наше сообщение id чата а также наш ответ
            outMess.setChatId(tempChatId);
            outMess.setText(input);

            //Отправка в чат
            try {
                execute(outMess);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
