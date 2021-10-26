package com.flightcheckin.integration.dao;

import java.sql.Timestamp;

public class Reservation {

	private Long id;
	private boolean checkedIn;
	private int numberOfBags;

	private Passenger passenger;
	
	private Flight flight;
	
	private Timestamp created;

	

	public boolean isCheckedIn() {
		return checkedIn;
	}

	public void setCheckedIn(boolean checkedIn) {
		this.checkedIn = checkedIn;
	}

	public int getNumberOfBags() {
		return numberOfBags;
	}

	public void setNumberOfBags(int numberOfBags) {
		this.numberOfBags = numberOfBags;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", checkedIn=" + checkedIn + ", numberOfBags=" + numberOfBags + ", passenger="
				+ passenger + ", flight=" + flight + ", created=" + created + "]";
	}
	
	

	
}
