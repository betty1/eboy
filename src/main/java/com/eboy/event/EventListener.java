package com.eboy.event;

import com.eboy.conversation.outgoing.OutgoingMessageHelper;
import com.eboy.conversation.outgoing.OutgoingMessageService;
import com.eboy.platform.Platform;
import com.eboy.platform.facebook.FacebookMessageService;
import com.eboy.platform.telegram.TelegramMessageService;
import com.google.common.eventbus.Subscribe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * Created by root1 on 19/11/16.
 */
@Component
public class EventListener {

    private OutgoingMessageService outgoingFacebookMessageService;
    private OutgoingMessageService outgoingTelegramMessageService;

    @Autowired
    public EventListener(@Qualifier(TelegramMessageService.QUALIFIER) OutgoingMessageService outgoingFacebookMessageService, @Qualifier(FacebookMessageService.QUALIFIER) OutgoingMessageService outgoingTelegramMessageService) {
        this.outgoingFacebookMessageService = outgoingFacebookMessageService;
        this.outgoingTelegramMessageService = outgoingTelegramMessageService;
    }

    private final static Logger logger = Logger.getLogger(EventListener.class.getName());

    @Subscribe
    public void handleEvent(IntentEvent event) {
        if (event.platform.equals(Platform.FACEBOOK)) {
            outgoingFacebookMessageService.sendText(String.valueOf(event.userId), "Intent event");
        } else {
            outgoingTelegramMessageService.sendText(String.valueOf(event.userId), "Intent event");
        }
    }

    @Subscribe
    public void handleEvent(UpdateEvent event) {
        if (event.platform.equals(Platform.FACEBOOK)) {
            outgoingFacebookMessageService.sendText(String.valueOf(event.userId), "Intent event");
        } else {
            outgoingTelegramMessageService.sendText(String.valueOf(event.userId), "Intent event");
        }
    }
}
