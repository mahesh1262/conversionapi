package com.playsafeholding.assessment;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class RouletteTask2Application implements CommandLineRunner {
	
	private static final Logger logger = LoggerFactory.getLogger(RouletteTask2Application.class);

	public static void main(String[] args) {
		logger.info("Starting roulette application");
		SpringApplication.run(RouletteTask2Application.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		new Round().playGame();
		
	}

}
