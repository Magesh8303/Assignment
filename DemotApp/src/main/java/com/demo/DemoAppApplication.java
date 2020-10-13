package com.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoAppApplication {

	private static final Logger logger = LogManager.getLogger(DemoAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoAppApplication.class, args);
		logger.info("Demo Application Started");
		logger.info("Info level log message");
		logger.debug("Debug level log message");
		logger.error("Error level log message");
	}

}
