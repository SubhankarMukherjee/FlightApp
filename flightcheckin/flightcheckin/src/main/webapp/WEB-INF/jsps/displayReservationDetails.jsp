<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Reservation</title>
</head>
<body>
<h2>Flight Details</h2></br>

Airlines: ${reservation.flight.operatingAirlines}</br>
Flight No: ${reservation.flight.flightNumber}</br>
Departure City: ${reservation.flight.departureCity}</br>
Arrival City: ${reservation.flight.arrivalCity}</br>
Date of Departure: ${reservation.flight.dateOfDeparture}</br>
Estimated Departure Time: ${reservation.flight.estimatedDepartureTime}</br>

<h2>Passenger Details</h2></br>

First Name : ${reservation.passenger.firstName}</br>
Last Name : ${reservation.passenger.lastName}</br>
Email : ${reservation.passenger.email}</br>
Phone : ${reservation.passenger.phone}</br>

<form action="completeCheckin" method="post">
Enter the number of bags: <input type="text" name="numberOfBags"/>
<input type="hidden" name="reservationId" value="${reservation.id}"/></br>
<input type="submit" value="Check In"/>
</form>
</body>
</html>