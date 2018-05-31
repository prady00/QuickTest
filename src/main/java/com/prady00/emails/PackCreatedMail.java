package com.prady00.emails;

public class PackCreatedMail implements Emails {

	private String to;
	private String body;
	private String subject;

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
	public void send() {
		// TODO Auto-generated method stub
		
	}
	
}
