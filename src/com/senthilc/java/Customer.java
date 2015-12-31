package com.senthilc.java;
import org.json.JSONObject;

public class Customer {
	private int id;
	private String firstName;
	private String lastName;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String country;
	
	public Customer() {}
	
	public Customer (JSONObject obj) {
		id = Integer.parseInt(obj.getString("id"));
		firstName = obj.getString("firstName");
		lastName = obj.getString("lastName");
		street = obj.getString("street");
		city = obj.getString("city");
		state = obj.getString("state");
		zip = obj.getString("zip");
		country = obj.getString("country");
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
}
