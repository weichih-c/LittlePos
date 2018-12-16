package com.wei.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GreetRest {

    private static final Logger logger = LoggerFactory.getLogger(GreetRest.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    @RequestMapping(method = RequestMethod.GET, value = "/greet")
    public void greet(){
        logger.info("Rest - /greet .");
        Map<String , String> msg = new HashMap<>();
        msg.put("greeting", "say hello");
        msg.put("lang", "english");
        this.jmsTemplate.convertAndSend(Application.QueueName, msg);
    }
}
