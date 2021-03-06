package com.flightreservation.service;

import java.io.File;
import java.sql.Timestamp;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightreservation.controller.FlightController;
import com.flightreservation.dao.ReservationRequest;
import com.flightreservation.entities.Flight;
import com.flightreservation.entities.Passenger;
import com.flightreservation.entities.Reservation;
import com.flightreservation.repository.FlightRepository;
import com.flightreservation.repository.PassengerRepository;
import com.flightreservation.repository.ReservationRepository;
import com.flightreservation.util.EmailUtil;
import com.flightreservation.util.createPDFItinenary;

@Service
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	private PassengerRepository passengerRepository;

	@Autowired
	private FlightRepository flightRepository;

	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private EmailUtil emailUtil;
	
	@Autowired
	private createPDFItinenary createPDFItinenary;

	private static Logger LOGGER= LoggerFactory.getLogger(ReservationServiceImpl.class);
	@Override
	@Transactional
	public Reservation bookFlight(ReservationRequest request) {

		LOGGER.info("Inside Service Reservation Class bookflight method");
		
		LOGGER.info("ReservationRequest: {}",request);
		// saving passenger
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());
		LOGGER.info("Saving Passenger");
		Passenger savedPassenger = passengerRepository.save(passenger);

		// getting flight
		Flight savedFlight = flightRepository.findById(request.getFlightId()).get();

		Reservation reservation = new Reservation();
		reservation.setCheckedIn(false);
		reservation.setNumberOfBags(0);
		reservation.setPassenger(savedPassenger);
		reservation.setFlight(savedFlight);
		
		reservation.setCreated(new Timestamp(System.currentTimeMillis()));
		LOGGER.info("Saving Reservation");
		Reservation savedReservation = reservationRepository.save(reservation);
		LOGGER.info("Generating PDF Itinenary");
		String filepath = "C:\\Subhankar\\JAVA\\Practice\\PracticeCRUDWeb\\Itinenary\\"+ savedReservation.getId()+".pdf";
		createPDFItinenary.createItinenary(savedReservation, filepath);
		LOGGER.info("Saving Passenger");
		emailUtil.generateItinenary(reservation.getPassenger().getEmail(), filepath);
		
		return savedReservation ;
	}

}
