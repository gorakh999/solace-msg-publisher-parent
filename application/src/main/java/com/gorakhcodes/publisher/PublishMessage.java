package com.gorakhcodes.publisher;

import com.gorakhcodes.config.SolaceSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PublishMessage {

    @Autowired
    private SolaceSender solaceSender;

    private String message = "Hi This is a Test Message Again";

    public void someMethod() throws Exception {
        solaceSender.sendMessage(message);
    }
}
