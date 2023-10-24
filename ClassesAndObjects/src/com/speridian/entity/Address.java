package com.speridian.entity;

import java.util.Objects;

public class Address {
	private String city;
	private String state;
	
	public Address() {
	}

	public Address(String city, String state) {
		this.city = city;
		this.state = state;
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
	
	public void print() {
		System.out.println("City: " + city);
		System.out.println("State: " + state);
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, state);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(city, other.city) && Objects.equals(state, other.state);
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + "]";
	}
}