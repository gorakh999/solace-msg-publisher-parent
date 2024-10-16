package com.gorakhcodes.config;

import javax.jms.Connection;
import javax.jms.Session;
import javax.jms.MessageProducer;
import javax.jms.TextMessage;
import javax.jms.Queue;
import javax.jms.ConnectionFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SolaceSender {

    private static final Logger log = LoggerFactory.getLogger(SolaceSender.class);
    @Autowired
    private ConnectionFactory connectionFactory;

    @Value("${solace.publisher.queue}")
    private String publisherQueue;

    public void sendMessage(String messageContent) throws Exception {
        log.info("Inside Sending Message.");
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue(publisherQueue);
        MessageProducer producer = session.createProducer(queue);
        TextMessage message = session.createTextMessage(messageContent);

        producer.send(message);
        log.info("Message sent to Queue: " + publisherQueue);
        session.close();
        connection.close();
    }
}

