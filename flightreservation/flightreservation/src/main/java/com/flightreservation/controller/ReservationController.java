package com.flightreservation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightreservation.dao.ReservationRequest;
import com.flightreservation.entities.Flight;
import com.flightreservation.entities.Reservation;
import com.flightreservation.repository.FlightRepository;
import com.flightreservation.service.ReservationService;
@Controller
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	private static Logger LOGGER= LoggerFactory.getLogger(ReservationController.class);
	@Autowired
	FlightRepository flightrepo;
	@GetMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId,ModelMap map)
	{
		LOGGER.info("Inside Reservation Controller method: showCompleteReservation()");
		Flight flight = flightrepo.findById(flightId).get();
		LOGGER.info("Flight:{}",flight);
		map.addAttribute("flight", flight);
		return "completeReservation";
	}
	
	@PostMapping("/completeReservation")
	public String completeReservation(ReservationRequest request,ModelMap map)
	{
		LOGGER.info("Inside Reservation Controller method: completeReservation()");
		
		Reservation ConfirmedReservation = reservationService.bookFlight(request);
		LOGGER.info("Confirmed Reservation:{}",ConfirmedReservation);
		map.addAttribute("msg", "Reservation Completed with Id:"+ ConfirmedReservation.getId());
		return "reservationConfirmation";
		
	}
}
