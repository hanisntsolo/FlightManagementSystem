package com.cg.flightmgmt.dto;

public class ScheduledFlight {
	
private Flight flight;
private int availableSeats;
private Schedule schedule;
private double fares; //cost per seat
public ScheduledFlight() {
}
public ScheduledFlight(Flight flight,int availableSeats,Schedule schedule,double fares) {
	this.flight=flight;
	this.availableSeats=availableSeats;
	this.schedule=schedule;
	this.fares=fares;
	
}
public Flight getFlight() {
	return flight;
}
public void setFlight(Flight flight) {
	this.flight = flight;
}
public int getAvailableSeats() {
	return availableSeats;
}
public void setAvailableSeats(int availableSeats) {
	this.availableSeats = availableSeats;
}
public Schedule getSchedule() {
	return schedule;
}
public void setSchedule(Schedule schedule) {
	this.schedule = schedule;
}
public double getFares() {
	return fares;
}
public void setFares(double fares) {
	this.fares = fares;
}
