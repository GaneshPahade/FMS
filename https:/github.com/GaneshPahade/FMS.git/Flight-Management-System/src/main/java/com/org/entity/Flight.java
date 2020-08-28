package com.org.entity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="flight")
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String source;
	private String destination;
	@Temporal(TemporalType.TIMESTAMP)
	private Date departureDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date arrivalDate;
	private String flighName;
	private String flighNo;
	private double price;
	private int capacity;
	
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

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", source=" + source + ", destination=" + destination + ", departureDate="
				+ departureDate + ", arrivalDate=" + arrivalDate + ", flighName=" + flighName + ", flighNo=" + flighNo
				+ ", price=" + price + ", capacity=" + capacity + "]";
	}
}
