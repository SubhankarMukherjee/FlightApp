package com.flightreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flightreservation.dao.ReservationUpdateRequest;
import com.flightreservation.entities.Reservation;
import com.flightreservation.repository.ReservationRepository;

@RestController
@CrossOrigin
public class ReservationRestController {

	@Autowired
	private ReservationRepository reservationRepository;
	@GetMapping("/reservation/{id}")
	public Reservation findReservation(@PathVariable Long id)
	{
		Reservation reservation = reservationRepository.findById(id).get();
		return reservation;
		
	}
	@PostMapping("/reservations")
	public Reservation findReservation(@RequestBody ReservationUpdateRequest request)
	{
		Reservation reservation = reservationRepository.findById(request.getId()).get();
		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(request.isCheckedIn());
		
		Reservation updatedReservation = reservationRepository.save(reservation);
		return updatedReservation;
		
	}
	
}
