package com.prady00.emails;

import javax.mail.MessagingException;

public interface Email {
	
	public void setSendTo(String to);
	
	public void setBody(String body);
	
	public void setSubject(String subject);
	
	public void send() throws Exception;
	
}
