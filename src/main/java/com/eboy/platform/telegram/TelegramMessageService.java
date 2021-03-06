package com.eboy.platform.telegram;

import com.eboy.nlp.Intent;
import com.eboy.platform.MessageService;
import com.eboy.platform.MessageType;
import com.pengrad.telegrambot.Callback;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramBotAdapter;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

@Component
@Qualifier(value = TelegramMessageService.QUALIFIER)
public class TelegramMessageService implements MessageService {

    public static final String QUALIFIER = "TelegramMessageService";

    private final static Logger logger = Logger.getLogger(TelegramMessageService.class.getName());

    @Override
    public void sendTextMessage(final String text, final String userId) {
        TelegramBot bot = TelegramBotAdapter.build(Constants.TOKEN);

        SendMessage message = new SendMessage(userId, text).parseMode(ParseMode.HTML);

        bot.execute(message, new Callback<SendMessage, com.pengrad.telegrambot.response.SendResponse>() {
            @Override
            public void onResponse(SendMessage request, com.pengrad.telegrambot.response.SendResponse response) {
                logger.info(response.toString());
                logger.info(request.toString());
            }

            @Override
            public void onFailure(SendMessage request, IOException e) {
                logger.warning(e.getLocalizedMessage());
            }
        });
    }

    @Override
    public void sendQuickReplies(final String text, final HashMap<String, Intent> repliesWithPayload, final String userId) {

    }

    @Override
    public void sendAttachment(final String url, final MessageType type, final String userId) {

    }

    @Override
    public void sendLoginTemplate(final String text, final String image, final String userId) {

    }

    @Override
    public void sendGenericTemplate(final List<String> titles, final List<String> subTitles, final List<String> imageUrls, final List<List<com.eboy.conversation.outgoing.dto.Button>> buttonLists, final String userId) {
    }

}
