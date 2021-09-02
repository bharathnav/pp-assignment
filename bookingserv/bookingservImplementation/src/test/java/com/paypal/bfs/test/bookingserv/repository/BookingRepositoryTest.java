package com.paypal.bfs.test.bookingserv.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.annotation.Rollback;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.util.TestUtil;

@DataJpaTest
public class BookingRepositoryTest {

	@Autowired
	private BookingRepository bookingRepository;;

	@Test
	public void testEmpty() {
		assertEquals(bookingRepository.findAll().isEmpty(), true);
	}

	@Test
	public void testSaveBooking() {
		Booking booking = TestUtil.getBooking();
		Booking savedBooking = bookingRepository.save(booking);

		assertNotNull(savedBooking);

		assertNotNull(savedBooking.getId());

		assertEquals(booking, savedBooking);
	}

	@Test
	public void testListEmptyAgain() {
		assertEquals(bookingRepository.findAll().isEmpty(), true);
		assertEquals(bookingRepository.findAll().size(), 0);
	}

	@Test
	@Rollback(false)
	public void testSaveBookingWithRollBack() {
		// Disabled rollback to test the size of get all
		Booking booking = TestUtil.getBooking();
		Booking savedBooking = bookingRepository.save(booking);

		assertNotNull(savedBooking);

		assertNotNull(savedBooking.getId());

		assertEquals(booking, savedBooking);

		assertEquals(bookingRepository.findAll().isEmpty(), false);
		assertEquals(bookingRepository.findAll().size(), 1);
	}

	@Test
	public void testBookingAsNull() {

		Exception exception = assertThrows(InvalidDataAccessApiUsageException.class, () -> {
			bookingRepository.save(null);
		});

		String expectedMessage = "Target object must not be null";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void testAddressInBookingAsNull() {
		Exception exception = assertThrows(ConstraintViolationException.class, () -> {
			Booking booking = TestUtil.getBooking();
			booking.setAddress(null);
			bookingRepository.save(booking);
		});

		String expectedMessage = "Validation failed for classes";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}
}
