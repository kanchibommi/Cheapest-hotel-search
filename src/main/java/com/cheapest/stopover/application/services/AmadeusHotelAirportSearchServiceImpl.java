package com.cheapest.stopover.application.services;

import java.util.ArrayList;
import java.util.List;

import com.cheapest.stopover.application.errors.AppErrorMessage;
import com.cheapest.stopover.application.models.RecommendedStayDetails;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

@Service
public class AmadeusHotelAirportSearchServiceImpl implements AmadeusHotelAirportSearchService {

	@Value("${amedus-search-airport-uri}")
	private String HOTEL_AIRPORT_SEARCH_URI;

	@Value("${amedus-search-airport-api-key}")
	private String HOTEL_AIRPORT_SEARCH_API_KEY;

	@Override
	public List<RecommendedStayDetails> getRecommendedHotelsForLocationAndDate(final String airportCode,
			final String checkInDate, final String checkOutDate) throws AppErrorMessage {

		String requestURI = HOTEL_AIRPORT_SEARCH_URI + "apikey=" + HOTEL_AIRPORT_SEARCH_API_KEY + "&location="
				+ airportCode + "&check_in=" + checkInDate + "&check_out=" + checkOutDate;

		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(requestURI, String.class);

		List<RecommendedStayDetails> resultList = new ArrayList<>();
		if (!StringUtils.isEmpty(result)) {
			JSONParser parser = new JSONParser();
			JSONObject jsonObject = null;
			try {
				jsonObject = (JSONObject) parser.parse(result);
			} catch (ParseException e) {
				throw new AppErrorMessage("Error parsing the search response");
			}

			ObjectMapper mapper = new ObjectMapper();
			if (jsonObject != null) {
				JSONArray listOfHotels = (JSONArray) jsonObject.get("results");
				
				for (Object object : listOfHotels) {
					if(resultList.size()==3){
						break;
					}
					RecommendedStayDetails recommendedStayDetails = mapper.convertValue(object,
							RecommendedStayDetails.class);
					resultList.add(recommendedStayDetails);
				}
			}
			else{
				throw new AppErrorMessage("No Search result found. Please try again");
			}

		}else{
			throw new AppErrorMessage("No Search result found. Please try again");
		}

		return resultList;
	}

}
