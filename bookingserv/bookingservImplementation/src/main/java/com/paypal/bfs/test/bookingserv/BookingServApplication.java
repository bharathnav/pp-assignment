package com.paypal.bfs.test.bookingserv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookingServApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(BookingServApplication.class);
	
    public static void main(String[] args) {
    	logger.info("Starting booking service application.");
        SpringApplication.run(BookingServApplication.class, args);
    }
}