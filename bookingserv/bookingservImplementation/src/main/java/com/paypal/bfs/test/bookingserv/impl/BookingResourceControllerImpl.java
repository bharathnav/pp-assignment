package com.paypal.bfs.test.bookingserv.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.bfs.test.bookingserv.api.BookingResourceController;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.service.BookingResourceService;

@RestController
public class BookingResourceControllerImpl implements BookingResourceController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BookingResourceService bookingResourceService;
	
	

    @Override
    public ResponseEntity<Booking> create(Booking booking) {
    	logger.debug("Received rest request to create a booking.");
    	return new ResponseEntity<Booking>(bookingResourceService.createBooking(booking), HttpStatus.CREATED);
    }

	@Override
	public ResponseEntity<List<Booking>> getAll() {
		logger.debug("Received rest request to get all bookings.");
		return new ResponseEntity<List<Booking>>(bookingResourceService.getAll(), HttpStatus.OK);
	}
}
