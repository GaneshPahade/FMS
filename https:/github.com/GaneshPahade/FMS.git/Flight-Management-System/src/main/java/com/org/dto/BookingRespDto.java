package com.org.dto;

import java.util.Date;

public class BookingRespDto {

	private String firstName;
	private String lastName;
	private String mobileNo;
	private String emailId;
	private String source;
	private String destination;
	private Date departureDate;
	private String flighName;
	private String flighNo;
	private String flightWay;
	private int travellerCount;
	private double actualPrice;
	private double discountPrice;
	private double netPrice;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

	public double getActualPrice() {
		return actualPrice;
	}

	public void setActualPrice(double actualPrice) {
		this.actualPrice = actualPrice;
	}

	public double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}

	public double getNetPrice() {
		return netPrice;
	}

	public void setNetPrice(double netPrice) {
		this.netPrice = netPrice;
	}

	@Override
	public String toString() {
		return "BookingRespDto [firstName=" + firstName + ", lastName=" + lastName + ", mobileNo=" + mobileNo
				+ ", emailId=" + emailId + ", source=" + source + ", destination=" + destination + ", departureDate="
				+ departureDate + ", flighName=" + flighName + ", flighNo=" + flighNo + ", flightWay=" + flightWay
				+ ", travellerCount=" + travellerCount + ", actualPrice=" + actualPrice + ", discountPrice="
				+ discountPrice + ", netPrice=" + netPrice + "]";
	}

}
