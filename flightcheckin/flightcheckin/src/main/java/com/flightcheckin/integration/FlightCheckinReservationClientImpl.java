package com.flightcheckin.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.flightcheckin.integration.dao.Reservation;
import com.flightcheckin.integration.dao.ReservationUpdateRequest;

@Component
public class FlightCheckinReservationClientImpl implements FlightCheckinReservationClient {
	
	@Autowired
	private RestTemplate template;

	@Override
	public Reservation findReservation(Long id) {
		
		String url = "http://localhost:8080/flightreservation/reservation/"+id;
		ResponseEntity<Reservation> entity = template.getForEntity(url, Reservation.class);
		
		return entity.getBody();
	}

	@Override
	public Reservation updateReservation(ReservationUpdateRequest request) {
		
		ResponseEntity<Reservation> entity = template.postForEntity("http://localhost:8080/flightreservation/reservations", request, Reservation.class);
		Reservation reservation = entity.getBody();
		return reservation;
	}

}
