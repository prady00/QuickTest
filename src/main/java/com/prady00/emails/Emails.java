package com.prady00.emails;

public interface Emails {
	
	public void setSendTo(String to);
	
	public void setBody(String body);
	
	public void setSubject(String subject);
	
	public void send();
	
}
