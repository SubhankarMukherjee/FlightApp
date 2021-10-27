package com.flightreservation.util;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {

	@Autowired
	JavaMailSender sender;
	
	private static Logger LOGGER= LoggerFactory.getLogger(EmailUtil.class);
	public void generateItinenary(String toadress, String filepath)
	{
		LOGGER.info("Inside EMAIL UTIL CLASS generateItinenary method");
		MimeMessage message = sender.createMimeMessage();
		
		try {
			MimeMessageHelper helper= new MimeMessageHelper(message,true);
			helper.setTo(toadress);
			helper.setFrom("email_confirmation@gmail.com");
			helper.setText("Dear Concerned, Please find the itenary");
			helper.setText("Dear Concerned, Please find the itenary");
			helper.addAttachment("Itinenary",new File(filepath));
			helper.setSubject("Email Itinenary");
			} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOGGER.info("Sending EMAIL from EMAIL UTIL");
		sender.send(message);
		
		
	}
}
