package com.cg.flightmgmt.dto;

import java.math.BigInteger;
import java.util.Objects;

/**
 * The functionality of a user being
 * 1.General user to do a booking
 * 2.Administrator to validate bookings, add/modify flights etc.
 * This class stores the user type (admin or the customer) and all user
 *  information.
 */
public class User {
private BigInteger userId;
private String userType;
private String userName;
private String password;
private String email;
private String mobileNumber;

	public User() {
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
