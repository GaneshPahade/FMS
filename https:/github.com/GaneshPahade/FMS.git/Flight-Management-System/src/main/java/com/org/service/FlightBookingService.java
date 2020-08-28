package com.org.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.org.dto.BookingRespDto;
import com.org.entity.Flight;
import com.org.entity.User;

@Service
public class FlightBookingService {
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public BookingRespDto bookFlight(long userId, long bookingId) {
		Flight flight = null;
		BookingRespDto bookingRespDto=new BookingRespDto();
		if (userId > 0 && bookingId > 0) {
			flight = entityManager.find(Flight.class, bookingId);
			User user = entityManager.find(User.class, userId);
			bookingRespDto.setSource(flight.getSource());
			bookingRespDto.setDestination(flight.getDestination());
			bookingRespDto.setFlighName(flight.getFlighName());
			bookingRespDto.setFlighNo(flight.getFlighNo());
			bookingRespDto.setDepartureDate(flight.getDepartureDate());
			bookingRespDto.setFirstName(user.getFirstName());
			bookingRespDto.setLastName(user.getLastName());
			bookingRespDto.setEmailId(user.getEmailId());
			bookingRespDto.setMobileNo(user.getMobileNo());
			bookingRespDto.setDiscountPrice(flight.getPrice() * user.getUserType().getDiscount() / 100);
			bookingRespDto.setActualPrice(flight.getPrice());
			bookingRespDto.setNetPrice(flight.getPrice() - flight.getPrice() * user.getUserType().getDiscount() / 100);
			flight.setId(flight.getId());
			flight.setCapacity(flight.getCapacity()-1);
			entityManager.merge(flight);
		}
		return bookingRespDto;
	}
}
