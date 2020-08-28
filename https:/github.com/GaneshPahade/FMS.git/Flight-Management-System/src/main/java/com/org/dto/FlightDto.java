package com.org.dto;

import java.io.Serializable;
import java.util.Date;

public class FlightDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	private String source;
	private String destination;
	private Date departureDate;
	private Date arrivalDate;
	private String flighName;
	private String flighNo;
	private String flightWay;
	private int travellerCount;
	private double price;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getFlighName() {
		return flighName;
	}

	public void setFlighName(String flighName) {
		this.flighName = flighName;
	}

	public String getFlighNo() {
		return flighNo;
	}

	public void setFlighNo(String flighNo) {
		this.flighNo = flighNo;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getFlightWay() {
		return flightWay;
	}

	public void setFlightWay(String flightWay) {
		this.flightWay = flightWay;
	}

	public int getTravellerCount() {
		return travellerCount;
	}

	public void setTravellerCount(int travellerCount) {
		this.travellerCount = travellerCount;
	}

	@Override
	public String toString() {
		return "FlightDto [id=" + id + ", source=" + source + ", destination=" + destination + ", departureDate="
				+ departureDate + ", arrivalDate=" + arrivalDate + ", flighName=" + flighName + ", flighNo=" + flighNo
				+ ", flightWay=" + flightWay + ", travellerCount=" + travellerCount + ", price=" + price + "]";
	}

}
