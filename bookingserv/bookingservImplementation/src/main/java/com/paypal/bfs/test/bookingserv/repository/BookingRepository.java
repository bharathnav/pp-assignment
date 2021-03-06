package com.paypal.bfs.test.bookingserv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paypal.bfs.test.bookingserv.api.model.Booking;


@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

}
