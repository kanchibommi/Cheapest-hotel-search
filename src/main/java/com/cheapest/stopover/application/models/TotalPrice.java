package com.cheapest.stopover.application.models;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class TotalPrice {
	
	@JsonProperty(value="amount")
	private String amount;
	
	@JsonProperty(value="currency")
	private String curreny;

	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	/**
	 * @return the curreny
	 */
	public String getCurreny() {
		return curreny;
	}

	/**
	 * @param curreny
	 *            the curreny to set
	 */
	public void setCurreny(String curreny) {
		this.curreny = curreny;
	}

}
