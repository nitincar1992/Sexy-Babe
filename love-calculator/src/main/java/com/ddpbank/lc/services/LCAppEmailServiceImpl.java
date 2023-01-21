package com.ddpbank.lc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class LCAppEmailServiceImpl implements LCAppEmailService {

	@Autowired
	JavaMailSender javaMailSender;

	@Override
	public void sendEmail(String yourName, String emailBox, String result) {

		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(emailBox);
		simpleMailMessage.setSubject("Love Calculator Application Results");
		simpleMailMessage.setText("Hi" + yourName + "the result predicted by LCApp is" + result);

		javaMailSender.send(simpleMailMessage);

	}

}
