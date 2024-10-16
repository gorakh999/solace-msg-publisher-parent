package com.gorakhcodes;

import com.gorakhcodes.config.SolaceSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SolaceMsgPublisherParentApplication implements CommandLineRunner {

	@Autowired
	private SolaceSender solaceSender;

	private static String message = "Hi This is a Test Message";

	public static void main(String[] args) {
		SpringApplication.run(SolaceMsgPublisherParentApplication.class, args);
    }
	@Override
	public void run(String... args) throws Exception {
		try {
			solaceSender.sendMessage(message);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
