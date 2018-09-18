package com.cheapest.stopover.application.services;

import java.util.List;

import com.cheapest.stopover.application.errors.AppErrorMessage;
import com.cheapest.stopover.application.models.RecommendedStayDetails;

public interface AmadeusHotelAirportSearchService {

    public List<RecommendedStayDetails> getRecommendedHotelsForLocationAndDate(String airportCode,
			String checkInDate, String checkOutDate) throws AppErrorMessage;
}
