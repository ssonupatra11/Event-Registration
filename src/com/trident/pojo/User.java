package com.trident.pojo;

public class User {
	private Integer regdNo;
	private String userName;
	private String fullName;
	private String password;
	private String address;
	private String mobileNumber;
	private String gender;
	private String eMail;
	private String idCard;
	private String typeOfRegistration;
	private String noOfTicket;
	public User() {
		super();
	}
	public User(String userName, String fullName, String password, String address, String mobileNumber, String gender,
			String eMail, String idCard) {
		super();
		this.userName = userName;
		this.fullName = fullName;
		this.password = password;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
		this.eMail = eMail;
		this.idCard = idCard;
		
	}

	public Integer getRegdNo() {
		return regdNo;
	}
	public void setRegdNo(Integer regdNo) {
		this.regdNo = regdNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getTypeOfRegistration() {
		return typeOfRegistration;
	}
	public void setTypeOfRegistration(String typeOfRegistration) {
		this.typeOfRegistration = typeOfRegistration;
	}
	public String getNoOfTicket() {
		return noOfTicket;
	}
	public void setNoOfTicket(String noOfTicket) {
		this.noOfTicket = noOfTicket;
	}
	
}
