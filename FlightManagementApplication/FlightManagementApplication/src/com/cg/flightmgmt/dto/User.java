package com.cg.flightmgmt.dto;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * The functionality of a user being
 * 1.General user to do a booking
 * 2.Administrator to validate bookings, add/modify flights etc.
 * This class stores the user type (admin or the customer) and all user
 *  information.
 */
@Entity
@Table(name="appUser")
@SequenceGenerator(name = "seq", initialValue = 14356, allocationSize = 50)
public class User {
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "seq")
@Id
private BigInteger userId;
private String userType;
private String userName;
private String password;
private String email;
private String mobileNumber;
@OneToMany(mappedBy= "userId")
private List<Booking> bookingList= new ArrayList<>();

	public User() {
	}

	public User(BigInteger userId) {
		this.userId = userId;
	}

	public User(String userType, String userName, String password,
			String email, String mobileNumber) {
		this.userType = userType;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.mobileNumber = mobileNumber;
	}

	public User(BigInteger userId, String password){
		this.userId= userId;
		this.password= password;
	}

	public String getMobileNumber() {
	return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public BigInteger getUserId() {
		return userId;
	}
	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Booking> getBookingList() {
		return bookingList;
	}
	public void setBookingList(List<Booking> bookingList) {
		this.bookingList = bookingList;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		User user = (User) o;
		return userId.equals(user.userId) &&
				userType.equals(user.userType) &&
				userName.equals(user.userName) &&
				password.equals(user.password) &&
				email.equals(user.email) &&
				mobileNumber.equals(user.mobileNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId, userType, userName, password, email, mobileNumber);
	}


	@Override
	public String toString() {
		return "User{" +
				"userId=" + userId +
				", userType='" + userType + '\'' +
				", userName='" + userName + '\'' +
				", password='" + password + '\'' +
				", email='" + email + '\'' +
				", mobileNumber='" + mobileNumber + '\'' +
				'}';
	}
}
