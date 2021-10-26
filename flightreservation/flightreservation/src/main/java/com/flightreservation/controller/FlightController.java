package com.flightreservation.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flightreservation.entities.Flight;
import com.flightreservation.repository.FlightRepository;
@Controller
public class FlightController {

	@Autowired
	FlightRepository flightrepo;
	@PostMapping("/findFlights")
	public String findFlight(@RequestParam("from") String from, @RequestParam("to") String to, 
			@RequestParam("departureDate") @DateTimeFormat(pattern="MM-dd-yyyy") Date departureDate, ModelMap map)
	
	{
		List<Flight> flights = flightrepo.findFlight(from,to,departureDate);
		map.addAttribute("flights",flights);
		return "displayFlights";
	}

}
