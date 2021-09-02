package com.paypal.bfs.test.bookingserv.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.paypal.bfs.test.bookingserv.api.model.Booking;

@RequestMapping(value = "/v1/bfs/booking")
public interface BookingResourceController {
    /**
     * Create {@link Booking} resource
     *
     * @param booking the booking object
     * @return the created booking
     */
    @PostMapping
    ResponseEntity<Booking> create(@Valid @RequestBody Booking booking);

    /**
	 * Get all bookings
	 * 
	 * @return all bookings
	 */
    @GetMapping(value = "/all")
	ResponseEntity<List<Booking>> getAll();
}
