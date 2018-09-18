package com.cheapest.stopover.application.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.cheapest.stopover.application.errors.AppErrorMessage;
import com.cheapest.stopover.application.models.HotelAirportSearchRequest;
import com.cheapest.stopover.application.models.HotelAirportSearchResponse;
import com.cheapest.stopover.application.models.PingResponse;
import com.cheapest.stopover.application.models.RecommendedStayDetails;
import com.cheapest.stopover.application.services.AmadeusHotelAirportSearchService;

@RestController
public class CheapestStopoverSearchController {

	@Autowired
	private AmadeusHotelAirportSearchService amadeusHotelAirportSearchService;

	@GetMapping("/ping")
	public PingResponse pingServer() {
		return new PingResponse();
	}

	@PostMapping("/search")
	public HotelAirportSearchResponse searchHotel(
			@RequestBody final HotelAirportSearchRequest hotelAirportSearchRequest) {

		if (hotelAirportSearchRequest == null || StringUtils.isEmpty(hotelAirportSearchRequest.getAirportCode())
				|| StringUtils.isEmpty(hotelAirportSearchRequest.getCheckInDate())
				|| StringUtils.isEmpty(hotelAirportSearchRequest.getCheckOutDate())) {
			HotelAirportSearchResponse hotelAirportSearchResponse = new HotelAirportSearchResponse();
			hotelAirportSearchResponse.setErrorMessage("Airport Code, Checkin Date and Checkout Date's are mandatory");
			return hotelAirportSearchResponse;
		}

		HotelAirportSearchResponse hotelAirportSearchResponse = new HotelAirportSearchResponse();

		try {
			List<RecommendedStayDetails> recommendedStayDetails = amadeusHotelAirportSearchService
					.getRecommendedHotelsForLocationAndDate(hotelAirportSearchRequest.getAirportCode(),
							hotelAirportSearchRequest.getCheckInDate(), hotelAirportSearchRequest.getCheckOutDate());
			hotelAirportSearchResponse.setRecommendedStayDetailsList(recommendedStayDetails);
		} catch (AppErrorMessage e) {
			hotelAirportSearchResponse.setErrorMessage(e.getErrorMessage());
		}

		return hotelAirportSearchResponse;
	}

}
