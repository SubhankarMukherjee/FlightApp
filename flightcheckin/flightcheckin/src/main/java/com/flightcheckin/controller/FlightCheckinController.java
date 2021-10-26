package com.flightcheckin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightcheckin.integration.FlightCheckinReservationClient;
import com.flightcheckin.integration.dao.Reservation;
import com.flightcheckin.integration.dao.ReservationUpdateRequest;

@Controller
public class FlightCheckinController {

	@Autowired
	FlightCheckinReservationClient client;
	private ReservationUpdateRequest request;
	
	@GetMapping("/showStartCheckin")
	public String showStartCheckin()
	{
		return "startCheckin";
		
	}
	
	@PostMapping("/startCheckin")
	public String startCheckin(@RequestParam("reservationId") Long id, ModelMap map)
	{
		Reservation reservation = client.findReservation(id);
		map.addAttribute("reservation", reservation);
		return "displayReservationDetails";
		
	}
	@PostMapping("/completeCheckin")
	public String startCheckin(@RequestParam("reservationId") Long id,@RequestParam("numberOfBags") int numberOfBags)
	{
		Reservation reservation = client.findReservation(id);
		ReservationUpdateRequest updateReservation = new ReservationUpdateRequest();
		updateReservation.setCheckedIn(true);
		updateReservation.setId(id);
		updateReservation.setNumberOfBags(numberOfBags);
		 client.updateReservation(updateReservation);
		return "checkinConfirmation";
		
	}
}
