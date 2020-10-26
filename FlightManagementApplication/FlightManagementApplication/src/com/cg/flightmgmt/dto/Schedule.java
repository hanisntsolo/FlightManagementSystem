package com.cg.flightmgmt.dto;

import java.time.LocalDateTime;
import java.util.Objects;
/**
 * All airport flight operations are
 * taken care in this class.
 * This class stores a flight schedule.
 */
public class Schedule {
	
	private Airport sourceAirport;
	private Airport destinationAirport;
	private LocalDateTime arrivalTime;
	private LocalDateTime departureTime;
	public Schedule() {}
		public Schedule(Airport sourceAirport,Airport destinationAirport,LocalDateTime arrivalTime,LocalDateTime departureTime)
		{
			this.sourceAirport=sourceAirport;
			this.destinationAirport=destinationAirport;
			this.arrivalTime=arrivalTime;
			this.departureTime=departureTime;
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

