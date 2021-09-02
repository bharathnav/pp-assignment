package com.paypal.bfs.test.bookingserv.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Entity class to represent address object.
 * @author bharatnavali
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Address {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	private String line1;
    private String line2;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    
}
