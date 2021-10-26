package com.flightcheckin;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.flightcheckin.integration.FlightCheckinReservationClient;
import com.flightcheckin.integration.dao.Reservation;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FlightcheckinApplicationTests {

	private Reservation findReservation;

	@Autowired
	private FlightCheckinReservationClient client;

	@Test
	public void findReservation()
	{
		
		findReservation = client.findReservation(1l);
		System.out.println(findReservation);
		
	}
}
