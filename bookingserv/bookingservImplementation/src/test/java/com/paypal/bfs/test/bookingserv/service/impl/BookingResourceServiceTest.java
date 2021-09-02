package com.paypal.bfs.test.bookingserv.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.repository.BookingRepository;
import com.paypal.bfs.test.bookingserv.util.TestUtil;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class BookingResourceServiceTest {
	
	
	
	@MockBean
	private BookingRepository bookingRepository;
	
	@InjectMocks
	private BookingResourceServiceImpl bookingResourceService;
	
	
	@Test
	public void testCreateBooking() {
		Booking booking = TestUtil.getBooking();
		Mockito.when(bookingRepository.save(booking)).thenReturn(booking);
		
		Booking savedBooking = bookingResourceService.createBooking(booking);
		
		assertEquals(booking, savedBooking);
	}
	
	@Test
	public void testCreateBookingException() {
		Booking booking = TestUtil.getBooking();
		Mockito.when(bookingRepository.save(booking)).thenThrow(new RuntimeException());
		
		
		Exception exception = null;
		try {
			bookingResourceService.createBooking(booking);
	    } catch (Exception t) {
	        exception = t;
	    }

	    assertNotNull(exception);
	}
	
	@Test
	public void testGetBooking() {
		List<Booking> list = new ArrayList<Booking>();
		Booking booking = TestUtil.getBooking();
		list.add(booking);
		
		Mockito.when(bookingRepository.findAll()).thenReturn(list);
		
		List<Booking> expectedList = bookingResourceService.getAll();
		
		assertEquals(expectedList, list);
	}
	
	@Test
	public void testMGetBookingMultiple() {
		List<Booking> list = new ArrayList<Booking>();
		int size = 10;
		for (int i = 0 ; i < size ; i++) {
			Booking booking = TestUtil.getBooking();
			list.add(booking);
		}
		
		
		Mockito.when(bookingRepository.findAll()).thenReturn(list);
		
		List<Booking> expectedList = bookingResourceService.getAll();
		
		assertEquals(expectedList, list);
		
		assertEquals(expectedList.size(), size);
	}
	
	@Test
	public void testGetAllException() {
		Mockito.when(bookingRepository.findAll()).thenThrow(new RuntimeException());
		
		Exception exception = null;
		try {
			bookingResourceService.getAll();
	    } catch (Exception t) {
	        exception = t;
	    }

	    assertNotNull(exception);
	}

}
