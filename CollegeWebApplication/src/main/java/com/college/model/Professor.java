package com.college.model;

public class Professor {
	private long id;

	private String address;

	private String firstname;

	private String lastname;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Professor(long id, String address, String firstname, String lastname) {
		this.id = id;
		this.address = address;
		this.firstname = firstname;
		this.lastname = lastname;
	}
	
	

}
