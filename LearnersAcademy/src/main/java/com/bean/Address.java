package com.bean;


import javax.persistence.Embeddable;

@Embeddable
public class Address {


	private String d_no;
	
	private String street;
	
	private String city;
	
	private String state;
	
	private String zipcode;

	public Address() {
		
	}
	public Address(String d_no, String street, String city, String state, String zipcode) {
		super();
		this.d_no = d_no;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	public String getD_no() {
		return d_no;
	}

	public void setD_no(String d_no) {
		this.d_no = d_no;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
}
