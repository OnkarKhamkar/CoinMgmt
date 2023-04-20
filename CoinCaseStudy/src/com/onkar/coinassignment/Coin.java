package com.onkar.coinassignment;


import java.io.Serializable;
import java.time.LocalDate;

public class Coin implements Serializable {
	String country;
	String denomination;
	int yearOfMinting;
	float currentValue;
	LocalDate acquiredDate;
	
	public Coin() {
		// TODO Auto-generated constructor stub
	}
	
	public Coin(String v1, String v2, int v3, float v4, LocalDate v5)
	{
		country=v1;
		denomination=v2;
		yearOfMinting=v3;
		currentValue=v4;
		acquiredDate=v5;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	public int getYearOfMinting() {
		return yearOfMinting;
	}

	public void setYearOfMinting(int yearOfMinting) {
		this.yearOfMinting = yearOfMinting;
	}

	public float getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(float currentValue) {
		this.currentValue = currentValue;
	}

	public LocalDate getAcquiredDate() {
		return acquiredDate;
	}

	public void setAcquiredDate(LocalDate acquiredDate) {
		this.acquiredDate = acquiredDate;
	}

}
