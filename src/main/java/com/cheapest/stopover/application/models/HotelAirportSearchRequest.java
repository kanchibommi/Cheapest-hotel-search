package com.cheapest.stopover.application.models;

public class HotelAirportSearchRequest {

	private String airportCode;
	private String checkInDate;
	private String checkOutDate;

	public String getAirportCode() {
		return airportCode;
	}

	public void setAirportCode(final String airportCode) {
		this.airportCode = airportCode;
	}

	public String getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(final String checkInDate) {
		this.checkInDate = checkInDate;
	}

	/**
	 * @return the checkOutDate
	 */
	public String getCheckOutDate() {
		return checkOutDate;
	}

	/**
	 * @param checkOutDate
	 *            the checkOutDate to set
	 */
	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

}
