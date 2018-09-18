package com.cheapest.stopover.application.models;

import java.util.List;

public class HotelAirportSearchResponse {

    private List<RecommendedStayDetails> recommendedStayDetailsList;
    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<RecommendedStayDetails> getRecommendedStayDetailsList() {
        return recommendedStayDetailsList;
    }

    public void setRecommendedStayDetailsList(final List<RecommendedStayDetails> recommendedStayDetailsList) {
        this.recommendedStayDetailsList = recommendedStayDetailsList;
    }
}
