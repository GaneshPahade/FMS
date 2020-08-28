package com.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.org.dto.BookingRespDto;
import com.org.service.FlightBookingService;

@RestController
public class BookingController {

	@Autowired
	FlightBookingService flightBookingService;
	@GetMapping("/flight/book/{userId}/{bookingId}")
	public BookingRespDto flightBook(@PathVariable("userId") long userId,@PathVariable("bookingId") long bookingId) {
		BookingRespDto bookingRespDto = flightBookingService.bookFlight(userId,bookingId);
		return bookingRespDto;
	}
}
