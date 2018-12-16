package com.wei.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MessageProcessor {

    private Logger logger = LoggerFactory.getLogger(MessageProcessor.class);

    @JmsListener(destination = Application.QueueName)
    public void onMessage(Map<String, String> msg) {
        logger.info("Receive msg: " + msg);
    }
}
