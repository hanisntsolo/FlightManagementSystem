package com.cg.flightmgmt.dto;

import java.math.BigInteger;
import java.util.Objects;

/**
 * This class stores all the details of a flight.
 */
public class Flight {
private BigInteger flightId;
private String carrierName;
private String flightModel;
private int seatCapacity;

  public Flight() {
  }

  public Flight(BigInteger flightId, String carrierName, String flightModel, int seatCapacity) {
    this.flightId = flightId;
    this.carrierName = carrierName;
    this.flightModel = flightModel;
    this.seatCapacity = seatCapacity;
  }

  public BigInteger getFlightId() {
    return flightId;
  }

  public void setFlightId(BigInteger flightId) {
    this.flightId = flightId;
  }

  public String getCarrierName() {
    return carrierName;
  }

  public void setCarrierName(String carrierName) {
    this.carrierName = carrierName;
  }

  public String getFlightModel() {
    return flightModel;
  }

  public void setFlightModel(String flightModel) {
    this.flightModel = flightModel;
  }

  public int getSeatCapacity() {
    return seatCapacity;
  }

  public void setSeatCapacity(int seatCapacity) {
    this.seatCapacity = seatCapacity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Flight flight = (Flight) o;
    return seatCapacity == flight.seatCapacity &&
        flightId.equals(flight.flightId) &&
        carrierName.equals(flight.carrierName) &&
        flightModel.equals(flight.flightModel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(flightId, carrierName, flightModel, seatCapacity);
  }

  @Override
  public String toString() {
    return "Flight{" +
        "flightId=" + flightId +
        ", carrierName='" + carrierName + '\'' +
        ", flightModel='" + flightModel + '\'' +
        ", seatCapacity=" + seatCapacity +
        '}';
  }
}
