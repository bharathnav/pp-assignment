package com.paypal.bfs.test.bookingserv.api.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity class to represent booking object.
 * @author bharatnavali
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Booking {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Size(min = 1, max = 255)
	@NotNull
	private String firstName;
	
	@Size(min = 1, max = 255)
	@NotNull
	private String lastName;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Please provide a date.")
    private Date dateOfBirth;
	
	@NotNull
	private Long checkIn;
	
	@NotNull
	private Long checkOut;
	
	@NotNull
	private BigDecimal totalPrice;
	
	@NotNull
	private BigDecimal deposit;
	
	@NotNull
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;

}
