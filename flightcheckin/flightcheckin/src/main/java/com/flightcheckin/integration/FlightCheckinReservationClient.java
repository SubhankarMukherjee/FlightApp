package com.flightcheckin.integration;

import com.flightcheckin.integration.dao.Reservation;
import com.flightcheckin.integration.dao.ReservationUpdateRequest;

public interface FlightCheckinReservationClient {
	
	public Reservation findReservation(Long id);
	public Reservation updateReservation(ReservationUpdateRequest request);

}
