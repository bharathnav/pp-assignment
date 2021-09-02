package com.paypal.bfs.test.bookingserv.impl;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.paypal.bfs.test.bookingserv.api.BookingResourceController;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.service.BookingResourceService;
import com.paypal.bfs.test.bookingserv.util.TestUtil;

@WebMvcTest(BookingResourceController.class)
public class BookingResourceControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BookingResourceService bookingResourceService;
	
	private static final String CREATE_URL = "/v1/bfs/booking";
	
	private static final String GET_URL = "/v1/bfs/booking/all";
	
	@Test
	public void testCreateBookingWithOutBookingData() throws Exception {
		Booking booking = TestUtil.getBooking();
		Mockito.when(bookingResourceService.createBooking(booking)).thenReturn(booking);

		String jsonInput = "";

		this.mockMvc.perform(post(CREATE_URL).contentType(MediaType.APPLICATION_JSON).content(jsonInput))
				.andExpect(status().isBadRequest());

	}
	
	@Test
	public void testCreateBookingWithOutFirstname() throws Exception {
		Booking booking = TestUtil.getBooking();
		Mockito.when(bookingResourceService.createBooking(booking)).thenReturn(booking);

		String jsonInput = "{\n"
				+ "        \"id\": 1,\n"
				+ "        \"lastName\": \"1\",\n"
				+ "        \"dateOfBirth\": \"2021-08-30T00:00:00.000+0000\",\n"
				+ "        \"checkIn\": 1630349060083,\n"
				+ "        \"checkOut\": 1630349060083,\n"
				+ "        \"totalPrice\": 500.00,\n"
				+ "        \"deposit\": 1000.00,\n"
				+ "        \"address\": {\n"
				+ "            \"id\": 1,\n"
				+ "            \"line1\": \"#5160/14\",\n"
				+ "            \"line2\": \"Ushe Nivasa\",\n"
				+ "            \"city\": \"Davanagere\",\n"
				+ "            \"state\": \"Karnataka\",\n"
				+ "            \"country\": \"India\",\n"
				+ "            \"zipCode\": \"577005\"\n"
				+ "        }\n"
				+ "    }";

		

		this.mockMvc.perform(post(CREATE_URL).contentType(MediaType.APPLICATION_JSON).content(jsonInput))
				.andExpect(status().isBadRequest());

	}
	
	@Test
	public void testCreateBookingWithoutLastName() throws Exception {
		Booking booking = TestUtil.getBooking();
		Mockito.when(bookingResourceService.createBooking(booking)).thenReturn(booking);

		String jsonInput = "{\n"
				+ "        \"id\": 1,\n"
				+ "        \"firstName\": \"Bharat\",\n"
				+ "        \"dateOfBirth\": \"2021-08-30T00:00:00.000+0000\",\n"
				+ "        \"checkIn\": 1630349060083,\n"
				+ "        \"checkOut\": 1630349060083,\n"
				+ "        \"totalPrice\": 500.00,\n"
				+ "        \"deposit\": 1000.00,\n"
				+ "        \"address\": {\n"
				+ "            \"id\": 1,\n"
				+ "            \"line1\": \"#5160/14\",\n"
				+ "            \"line2\": \"Ushe Nivasa\",\n"
				+ "            \"city\": \"Davanagere\",\n"
				+ "            \"state\": \"Karnataka\",\n"
				+ "            \"country\": \"India\",\n"
				+ "            \"zipCode\": \"577005\"\n"
				+ "        }\n"
				+ "    }";

		

		this.mockMvc.perform(post(CREATE_URL).contentType(MediaType.APPLICATION_JSON).content(jsonInput))
				.andExpect(status().isBadRequest());

	}
	
	@Test
	public void testCreateBookingWithoutCheckIn() throws Exception {
		Booking booking = TestUtil.getBooking();
		Mockito.when(bookingResourceService.createBooking(booking)).thenReturn(booking);

		String jsonInput = "{\n"
				+ "        \"id\": 1,\n"
				+ "        \"firstName\": \"Bharat\",\n"
				+ "        \"lastName\": \"1\",\n"
				+ "        \"dateOfBirth\": \"2021-08-30T00:00:00.000+0000\",\n"
				+ "        \"checkOut\": 1630349060083,\n"
				+ "        \"totalPrice\": 500.00,\n"
				+ "        \"deposit\": 1000.00,\n"
				+ "        \"address\": {\n"
				+ "            \"id\": 1,\n"
				+ "            \"line1\": \"#5160/14\",\n"
				+ "            \"line2\": \"Ushe Nivasa\",\n"
				+ "            \"city\": \"Davanagere\",\n"
				+ "            \"state\": \"Karnataka\",\n"
				+ "            \"country\": \"India\",\n"
				+ "            \"zipCode\": \"577005\"\n"
				+ "        }\n"
				+ "    }";

		

		this.mockMvc.perform(post(CREATE_URL).contentType(MediaType.APPLICATION_JSON).content(jsonInput))
				.andExpect(status().isBadRequest());

	}
	
	@Test
	public void testCreateBookingWithoutCheckOut() throws Exception {
		Booking booking = TestUtil.getBooking();
		Mockito.when(bookingResourceService.createBooking(booking)).thenReturn(booking);

		String jsonInput = "{\n"
				+ "        \"id\": 1,\n"
				+ "        \"firstName\": \"Bharat\",\n"
				+ "        \"lastName\": \"1\",\n"
				+ "        \"dateOfBirth\": \"2021-08-30T00:00:00.000+0000\",\n"
				+ "        \"checkOut\": 1630349060083,\n"
				+ "        \"totalPrice\": 500.00,\n"
				+ "        \"deposit\": 1000.00,\n"
				+ "        \"address\": {\n"
				+ "            \"id\": 1,\n"
				+ "            \"line1\": \"#5160/14\",\n"
				+ "            \"line2\": \"Ushe Nivasa\",\n"
				+ "            \"city\": \"Davanagere\",\n"
				+ "            \"state\": \"Karnataka\",\n"
				+ "            \"country\": \"India\",\n"
				+ "            \"zipCode\": \"577005\"\n"
				+ "        }\n"
				+ "    }";

		

		this.mockMvc.perform(post(CREATE_URL).contentType(MediaType.APPLICATION_JSON).content(jsonInput))
				.andExpect(status().isBadRequest());

	}
	
	@Test
	public void testCreateBookingWithoutAddress() throws Exception {
		Booking booking = TestUtil.getBooking();
		Mockito.when(bookingResourceService.createBooking(booking)).thenReturn(booking);

		String jsonInput = "{\n"
				+ "        \"id\": 1,\n"
				+ "        \"firstName\": \"Bharat\",\n"
				+ "        \"lastName\": \"1\",\n"
				+ "        \"dateOfBirth\": \"2021-08-30T00:00:00.000+0000\",\n"
				+ "        \"checkIn\": 1630349060083,\n"
				+ "        \"checkOut\": 1630349060083,\n"
				+ "        \"totalPrice\": 500.00,\n"
				+ "        \"deposit\": 1000.00,\n"
				+ "    }";

		

		this.mockMvc.perform(post(CREATE_URL).contentType(MediaType.APPLICATION_JSON).content(jsonInput))
				.andExpect(status().isBadRequest());

	}


	@Test
	public void testCreateBooking() throws Exception {
		Booking booking = TestUtil.getBooking();
		Mockito.when(bookingResourceService.createBooking(booking)).thenReturn(booking);

		String jsonInput = "{\n"
				+ "        \"id\": 1,\n"
				+ "        \"firstName\": \"Bharat\",\n"
				+ "        \"lastName\": \"1\",\n"
				+ "        \"dateOfBirth\": \"2021-08-30T00:00:00.000+0000\",\n"
				+ "        \"checkIn\": 1630349060083,\n"
				+ "        \"checkOut\": 1630349060083,\n"
				+ "        \"totalPrice\": 500.00,\n"
				+ "        \"deposit\": 1000.00,\n"
				+ "        \"address\": {\n"
				+ "            \"id\": 1,\n"
				+ "            \"line1\": \"#5160/14\",\n"
				+ "            \"line2\": \"Ushe Nivasa\",\n"
				+ "            \"city\": \"Davanagere\",\n"
				+ "            \"state\": \"Karnataka\",\n"
				+ "            \"country\": \"India\",\n"
				+ "            \"zipCode\": \"577005\"\n"
				+ "        }\n"
				+ "    }";

		

		this.mockMvc.perform(post(CREATE_URL).contentType(MediaType.APPLICATION_JSON).content(jsonInput))
				.andExpect(status().isCreated());

	}
	
	@Test
	public void testGetAllBookings() throws Exception {
		List<Booking> list = new ArrayList<Booking>();
		Booking booking = TestUtil.getBooking();
		list.add(booking);
		Mockito.when(bookingResourceService.getAll()).thenReturn(list);
		
		this.mockMvc.perform(get(GET_URL).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
	
	@Test
	public void testGetAllBookingsSize10() throws Exception {
		List<Booking> list = new ArrayList<Booking>();
		int size = 10;
		for (int i = 0 ; i < size ; i++) {
			Booking booking = TestUtil.getBooking();
			list.add(booking);
		}
		Mockito.when(bookingResourceService.getAll()).thenReturn(list);
		
		this.mockMvc.perform(get(GET_URL).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
}
