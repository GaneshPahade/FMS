package com.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.dto.FlightDto;
import com.org.entity.Flight;
import com.org.service.FlightSearchService;

@RestController
public class SearchController {

	@Autowired
	FlightSearchService flightSearchService;
	@PostMapping("/flight/search")
	public List<Flight> getFlightList(@RequestBody FlightDto flightDto) {
		List<Flight> searchFlightList = flightSearchService.searchFlight(flightDto);
		return searchFlightList;
	}
}
