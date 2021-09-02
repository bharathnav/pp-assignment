package com.paypal.bfs.test.bookingserv.util;

import java.math.BigDecimal;
import java.util.Date;

import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Booking;

public class TestUtil {
	public static Booking getBooking() {
		Address address = new Address();
		address.setLine1("#test/14");
		address.setLine2("Some Nivasa");
		address.setCity("fbg");
		address.setZipCode("345332");
		address.setCountry("India");
		address.setState("Karnataka");
		
		Booking booking = new Booking();
    	booking.setFirstName("Test");
    	booking.setLastName("User");
    	booking.setCheckIn(System.currentTimeMillis());
    	booking.setCheckOut(System.currentTimeMillis());
    	booking.setDateOfBirth(new Date());
    	booking.setDeposit(new BigDecimal(1000));
    	booking.setTotalPrice(new BigDecimal(500));
    	
    	booking.setAddress(address);
//    	List<Booking> list = new ArrayList<Booking>();
//    	list.add(book);
    	
    	return booking;
	}
}
