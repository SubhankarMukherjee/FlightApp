package com.flightreservation.service;

import com.flightreservation.dao.ReservationRequest;
import com.flightreservation.entities.Reservation;

public interface ReservationService {
public Reservation bookFlight(ReservationRequest request);
}
