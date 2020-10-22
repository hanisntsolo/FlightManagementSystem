package com.cg.flightmgmt.dto;

import java.math.BigInteger;
import java.util.Objects;

/**
 * This class stores all the details of the travelling passenger.
 */
public class Passenger {
private BigInteger pnrNumber;
private String passengerName;
private int age;
private BigInteger passengerUIN;
private Double luggage;
	public Passenger() {

	}
	public Passenger(BigInteger pnrNumber,String passengerName,int age,BigInteger passengerUIN,Double luggage)
	{
		this.pnrNumber=pnrNumber;
		this.passengerName=passengerName;
		this.age=age;
		this.passengerUIN=passengerUIN;
		this.luggage=luggage;
	}
	public BigInteger getPnrNumber() {
		return pnrNumber;
	}
	public void setPnrNumber(BigInteger pnrNumber) {
		this.pnrNumber = pnrNumber;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public BigInteger getPassengerUIN() {
		return passengerUIN;
	}
	public void setPassengerUIN(BigInteger passengerUIN) {
		this.passengerUIN = passengerUIN;
	}
	public Double getLuggage() {
		return luggage;
	}
	public void setLuggage(Double luggage) {
		this.luggage = luggage;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Passenger passenger = (Passenger) o;
		return age == passenger.age &&
				pnrNumber.equals(passenger.pnrNumber) &&
				passengerName.equals(passenger.passengerName) &&
				passengerUIN.equals(passenger.passengerUIN) &&
				luggage.equals(passenger.luggage);
	}

	@Override
	public int hashCode() {
		return Objects.hash(pnrNumber, passengerName, age, passengerUIN, luggage);
	}

	@Override
	public String toString() {
		return "Passenger{" +
				"pnrNumber=" + pnrNumber +
				", passengerName='" + passengerName + '\'' +
				", age=" + age +
				", passengerUIN=" + passengerUIN +
				", luggage=" + luggage +
				'}';
	}
}
