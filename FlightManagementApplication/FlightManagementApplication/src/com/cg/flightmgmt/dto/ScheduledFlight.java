package com.cg.flightmgmt.dto;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Various schedules are fetched and
 * manipulated through this class.
 * This class stores a flight that is scheduled along with its schedule
 * and the vacancy.
 */
@Entity
@Table(name = "scheduledflight")
public class ScheduledFlight {
	//==========Attributes============//
	@Id
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

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ScheduledFlight that = (ScheduledFlight) o;
		return availableSeats == that.availableSeats &&
				Double.compare(that.fares, fares) == 0 &&
				flight.equals(that.flight) &&
				schedule.equals(that.schedule);
	}

	@Override
	public int hashCode() {
		return Objects.hash(flight, availableSeats, schedule, fares);
	}

	@Override
	public String toString() {
		return "ScheduledFlight{" +
				"flight=" + flight +
				", availableSeats=" + availableSeats +
				", schedule=" + schedule +
				", fares=" + fares +
				'}';
	}
}