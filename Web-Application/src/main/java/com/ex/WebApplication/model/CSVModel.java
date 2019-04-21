package com.ex.WebApplication.model;

public class CSVModel {

	private String firstName;
	private String lastName;
	private String id;
	private String id2;

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId2() {
		return id2;
	}

	public void setId2(String id2) {
		this.id2 = id2;
	}

	/*
	 * public CSVModel(String firstName, String lastName, String id, String id2) {
	 * this.firstName = firstName; this.lastName = lastName; this.id = id; this.id2
	 * = id2; }
	 */

	@Override
	public String toString() {
		return  "{firstName:" + firstName + ", lastName:" + lastName + ", id:" + id + ", id2:" + id2 + "}";
	}

	
	

}
