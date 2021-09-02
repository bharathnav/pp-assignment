package com.paypal.bfs.test.bookingserv.service;

import java.util.List;

import com.paypal.bfs.test.bookingserv.api.model.Booking;

/**
 * Interface for booking service
 * @author bharatnavali
 *
 */
public interface BookingResourceService {
	
	/**
	 * Method to create booking
	 * @param booking
	 * @return successful booking
	 */
	public Booking createBooking(Booking booking);
	
	/**
	 * Get all bookings
	 * @return Get all bookings
	 */
	public List<Booking> getAll();
}
