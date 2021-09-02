package com.paypal.bfs.test.bookingserv.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.repository.BookingRepository;
import com.paypal.bfs.test.bookingserv.service.BookingResourceService;

@Service
@Transactional
public class BookingResourceServiceImpl implements BookingResourceService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BookingRepository bookingRepository;

	@Override
	public Booking createBooking(Booking booking) {
		logger.debug("In create booking service to create booking.");
		return bookingRepository.save(booking);
	}

	@Override
	public List<Booking> getAll() {
		logger.debug("In get all service to fetch the bookings.");
		return bookingRepository.findAll();
	}

}
