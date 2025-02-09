package com.cg.flightmgmt.dto;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/*
 * All airport flight operations are
 * taken care in this class.
 * This class stores a flight schedule.
 */
@Embeddable
public class Schedule {
	//==========Attributes============//
	@OneToOne
	private Airport sourceAirport;
	@OneToOne
	private Airport destinationAirport;
	private LocalDateTime arrivalTime;
	private LocalDateTime departureTime;
	private LocalDate arrivalDate;
	public Schedule() {}
		public Schedule(Airport sourceAirport,Airport destinationAirport, LocalDateTime arrivalTime, LocalDateTime departureTime, LocalDate arrivalDate)
		{
			this.sourceAirport=sourceAirport;
			this.destinationAirport=destinationAirport;
			this.arrivalTime=arrivalTime;
			this.departureTime=departureTime;
			this.arrivalDate= arrivalDate;
		}
		public Airport getSourceAirport() {
			return sourceAirport;
		}
		public void setSourceAirport(Airport sourceAirport) {
			this.sourceAirport = sourceAirport;
		}
		public Airport getDestinationAirport() {
			return destinationAirport;
		}
		public void setDestinationAirport(Airport destinationAirport) {
			this.destinationAirport = destinationAirport;
		}
		public LocalDateTime getArrivalTime() {
			return arrivalTime;
		}
		public void setArrivalTime(LocalDateTime arrivalTime) {
			this.arrivalTime = arrivalTime;
		}
		public LocalDateTime getDepartureTime() {
			return departureTime;
		}
		public void setDepartureTime(LocalDateTime departureTime) {
			this.departureTime = departureTime;
		}

		public LocalDate getArrivalDate() {
			return arrivalDate;
		}

		public void setArrivalDate(LocalDate arrivalDate) {
			this.arrivalDate = arrivalDate;
		}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Schedule schedule = (Schedule) o;
		return sourceAirport.equals(schedule.sourceAirport) &&
				destinationAirport.equals(schedule.destinationAirport) &&
				arrivalTime.equals(schedule.arrivalTime) &&
				departureTime.equals(schedule.departureTime);
	}

	@Override
	public int hashCode() {
		return Objects.hash(sourceAirport, destinationAirport, arrivalTime, departureTime);
	}

	@Override
	public String toString() {
		return "Schedule{" +
				"sourceAirport=" + sourceAirport +
				", destinationAirport=" + destinationAirport +
				", arrivalTime=" + arrivalTime +
				", departureTime=" + departureTime +
				'}';
	}
}

