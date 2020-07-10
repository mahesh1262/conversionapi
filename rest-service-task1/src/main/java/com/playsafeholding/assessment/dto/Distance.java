package com.playsafeholding.assessment.dto;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * POJO for storing and getting kilometers to miles and vice versa mapping.
 * 
 * @author mahesh
 *
 */
public class Distance {
	private BigDecimal kilometers;
	private BigDecimal miles;
	
	public BigDecimal getKilometers() {
		return kilometers;
	}
	
	public void setKilometers(BigDecimal kilometers) {
		this.kilometers = kilometers;
		this.miles = kilometers.divide(new BigDecimal(1.609344), MathContext.DECIMAL64);
	}

	public void setMiles(BigDecimal miles) {
		this.miles = miles;
		this.kilometers = this.miles.multiply(new BigDecimal(1.609344));
	}

	public BigDecimal getMiles() {
		return miles;
	}
}
