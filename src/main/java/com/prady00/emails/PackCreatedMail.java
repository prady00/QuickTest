package com.prady00.emails;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;


public class PackCreatedMail implements Email {

	private String to;
	private String body;
	private String subject;
	
	@Autowired
	public JavaMailSender sender;


	public PackCreatedMail(String to, String body, String subject) {
		super();
		this.to = to;
		this.body = body;
		this.subject = subject;
	}

	@Override
	public void setSendTo(String to) {
		this.to = to;
	}

	@Override
	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public void send() throws MessagingException, MailException {
		
	        MimeMessage message = sender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message);
	        
	        helper.setTo(this.to);
	        helper.setText(this.body);
	        helper.setSubject(this.subject);
	        
	        sender.send(message);
	   
	}
	
}
