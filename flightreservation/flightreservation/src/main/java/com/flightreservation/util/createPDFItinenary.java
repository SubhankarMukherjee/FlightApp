package com.flightreservation.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.stereotype.Component;

import com.flightreservation.entities.Reservation;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Component
public class createPDFItinenary {

	public void createItinenary(Reservation reservation, String filepath) {
		Document doc = new Document();
		Chunk chunk;
		try {
			PdfWriter.getInstance(doc, new FileOutputStream(filepath));
			doc.open();
			Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 14, BaseColor.BLACK);
			chunk = new Chunk("Please find your itenary below\n", font);

			doc.add(chunk);
			doc.add(new Phrase("\n"));

			doc.add(generateItenary(reservation));
			doc.add(new Phrase("\n"));

			chunk = new Chunk("Regards", font);
			doc.add(chunk);
			doc.add(new Phrase("\n"));
			chunk = new Chunk("Airlines Company Pallabi Pvt LTD", font);
			doc.add(chunk);
			doc.close();

		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private PdfPTable generateItenary(Reservation reservation) {
		// TODO Auto-generated method stub
		PdfPTable table = new PdfPTable(2);

		PdfPCell cell;

		cell = new PdfPCell(new Phrase("Flight Itinenary"));
		cell.setColspan(2);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("Flight Details"));
		cell.setColspan(2);
		table.addCell(cell);

		table.addCell(new Phrase("Airlines"));
		table.addCell(reservation.getFlight().getOperatingAirlines());

		table.addCell(new Phrase("Flight Number"));
		table.addCell(reservation.getFlight().getFlightNumber());

		table.addCell(new Phrase("Departure City"));
		table.addCell(reservation.getFlight().getDepartureCity());

		table.addCell(new Phrase("Arrival City"));
		table.addCell(reservation.getFlight().getArrivalCity());

		table.addCell(new Phrase("Date Of Departure"));
		table.addCell(reservation.getFlight().getDateOfDeparture().toString());

		table.addCell(new Phrase("Estimated Time of Departure"));
		table.addCell(reservation.getFlight().getEstimatedDepartureTime().toString());

		cell = new PdfPCell(new Phrase("Passenger Details"));
		cell.setColspan(2);
		table.addCell(cell);

		table.addCell(new Phrase("Paseenger First Name"));
		table.addCell(reservation.getPassenger().getFirstName());

		table.addCell(new Phrase("Paseenger Last Name"));
		table.addCell(reservation.getPassenger().getLastName());

		table.addCell(new Phrase("Paseenger Email"));
		table.addCell(reservation.getPassenger().getEmail());

		table.addCell(new Phrase("Paseenger Phone"));
		table.addCell(reservation.getPassenger().getPhone());

		return table;
	}
}
