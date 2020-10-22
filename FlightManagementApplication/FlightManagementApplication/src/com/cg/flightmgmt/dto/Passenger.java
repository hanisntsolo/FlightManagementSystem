package com.cg.flightmgmt.dto;

import java.math.BigInteger;

public class Passenger {
private BigInteger pnrNumber;
private String passengerName;
private int age;
private BigInteger passengerUIN;
private Double luggage;
public Passenger() {}
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
}
