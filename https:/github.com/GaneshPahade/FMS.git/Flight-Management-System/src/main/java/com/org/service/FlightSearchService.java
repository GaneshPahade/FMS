package com.org.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;

import com.org.dto.FlightDto;
import com.org.entity.Flight;

@Service
public class FlightSearchService {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Flight> searchFlight(FlightDto flightDto) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Flight> criteriaQuery = criteriaBuilder.createQuery(Flight.class);
		Root<Flight> flightRoot = criteriaQuery.from(Flight.class);
		List<Predicate> predicateList = new ArrayList<Predicate>();
		Calendar calendar = new GregorianCalendar();
		int year, month, day;
		if (flightDto.getSource() != null && !flightDto.getSource().isEmpty()) {
			predicateList.add(criteriaBuilder.equal(flightRoot.get("source"), flightDto.getSource()));
		}
		if (flightDto.getDestination() != null && !flightDto.getDestination().isEmpty()) {
			predicateList.add(criteriaBuilder.equal(flightRoot.get("destination"), flightDto.getDestination()));
		}
		if (flightDto.getDepartureDate() != null) {
			Path<Date> ldt = flightRoot.<Date>get("departureDate");
			calendar.setTime(flightDto.getDepartureDate());
			year = calendar.get(Calendar.YEAR);
			month = calendar.get(Calendar.MONTH) + 1;
			day = calendar.get(Calendar.DAY_OF_MONTH);
			Expression<Integer> dbYear = criteriaBuilder.function("year", Integer.class, ldt);
			Expression<Integer> dbMonth = criteriaBuilder.function("month", Integer.class, ldt);
			Expression<Integer> dbDay = criteriaBuilder.function("day", Integer.class, ldt);
			predicateList.add(criteriaBuilder.equal(dbYear, year));
			predicateList.add(criteriaBuilder.equal(dbMonth, month));
			predicateList.add(criteriaBuilder.equal(dbDay, day));
		}
		if (flightDto.getArrivalDate() != null) {
			Path<Date> ldt = flightRoot.<Date>get("arrivalDate");
			calendar.setTime(flightDto.getArrivalDate());
			year = calendar.get(Calendar.YEAR);
			month = calendar.get(Calendar.MONTH) + 1;
			day = calendar.get(Calendar.DAY_OF_MONTH);
			Expression<Integer> dbYear = criteriaBuilder.function("year", Integer.class, ldt);
			Expression<Integer> dbMonth = criteriaBuilder.function("month", Integer.class, ldt);
			Expression<Integer> dbDay = criteriaBuilder.function("day", Integer.class, ldt);
			predicateList.add(criteriaBuilder.equal(dbYear, year));
			predicateList.add(criteriaBuilder.equal(dbMonth, month));
			predicateList.add(criteriaBuilder.equal(dbDay, day));
		}
		if (flightDto.getFlighName() != null && !flightDto.getFlighName().isEmpty()) {
			predicateList.add(criteriaBuilder.equal(flightRoot.get("flighName"), flightDto.getFlighName()));
		}
		if (flightDto.getFlighNo() != null && !flightDto.getFlighNo().isEmpty()) {
			predicateList.add(criteriaBuilder.equal(flightRoot.get("flighNo"), flightDto.getFlighNo()));
		}
		if ("ONEWAY".equalsIgnoreCase(flightDto.getFlightWay()) && flightDto.getSource() != null
				&& !flightDto.getSource().isEmpty() && flightDto.getDestination() != null
				&& !flightDto.getDestination().isEmpty() && flightDto.getDepartureDate() != null) {
			predicateList.add(criteriaBuilder.equal(flightRoot.get("source"), flightDto.getSource()));
			predicateList.add(criteriaBuilder.equal(flightRoot.get("destination"), flightDto.getDestination()));
			Path<Date> ldt = flightRoot.<Date>get("departureDate");
			Expression<Integer> dbYear = criteriaBuilder.function("year", Integer.class, ldt);
			Expression<Integer> dbMonth = criteriaBuilder.function("month", Integer.class, ldt);
			Expression<Integer> dbDay = criteriaBuilder.function("day", Integer.class, ldt);
			calendar.setTime(flightDto.getDepartureDate());
			year = calendar.get(Calendar.YEAR);
			month = calendar.get(Calendar.MONTH) + 1;
			day = calendar.get(Calendar.DAY_OF_MONTH);
			predicateList.add(criteriaBuilder.equal(dbYear, year));
			predicateList.add(criteriaBuilder.equal(dbMonth, month));
			predicateList.add(criteriaBuilder.equal(dbDay, day));
		}
		if ("TWOWAY".equalsIgnoreCase(flightDto.getFlightWay()) && flightDto.getSource() != null
				&& !flightDto.getSource().isEmpty() && flightDto.getDestination() != null
				&& !flightDto.getDestination().isEmpty() && flightDto.getDepartureDate() != null
				&& flightDto.getArrivalDate() != null) {
			Path<Date> ldta = flightRoot.<Date>get("arrivalDate");
			predicateList.add(criteriaBuilder.equal(flightRoot.get("source"), flightDto.getSource()));
			predicateList.add(criteriaBuilder.equal(flightRoot.get("destination"), flightDto.getDestination()));
			Path<Date> ldt = flightRoot.<Date>get("departureDate");
			Expression<Integer> dbYear = criteriaBuilder.function("year", Integer.class, ldt);
			Expression<Integer> dbMonth = criteriaBuilder.function("month", Integer.class, ldt);
			Expression<Integer> dbDay = criteriaBuilder.function("day", Integer.class, ldt);
			Expression<Integer> dbYearA = criteriaBuilder.function("year", Integer.class, ldta);
			Expression<Integer> dbMonthA = criteriaBuilder.function("month", Integer.class, ldta);
			Expression<Integer> dbDayA = criteriaBuilder.function("day", Integer.class, ldta);
			calendar.setTime(flightDto.getDepartureDate());
			Calendar cal = new GregorianCalendar();
			cal.setTime(flightDto.getDepartureDate());
			year = calendar.get(Calendar.YEAR);
			month = calendar.get(Calendar.MONTH) + 1;
			day = calendar.get(Calendar.DAY_OF_MONTH);
			int year1 = cal.get(Calendar.YEAR);
			int month1 = cal.get(Calendar.MONTH) + 1;
			int day1 = cal.get(Calendar.DAY_OF_MONTH);
			predicateList.add(criteriaBuilder.equal(dbYear, year));
			predicateList.add(criteriaBuilder.equal(dbMonth, month));
			predicateList.add(criteriaBuilder.equal(dbDay, day));
			predicateList.add(criteriaBuilder.equal(dbYearA, year1));
			predicateList.add(criteriaBuilder.equal(dbMonthA, month1));
			predicateList.add(criteriaBuilder.equal(dbDayA, day1));
		}
		criteriaQuery.select(flightRoot).where(predicateList.toArray(new Predicate[predicateList.size()]));
		List<Flight> flightList = entityManager.createQuery(criteriaQuery).getResultList();
		return flightList;
	}

}
