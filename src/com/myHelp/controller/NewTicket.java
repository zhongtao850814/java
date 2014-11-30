package com.myHelp.controller;

public class NewTicket {
	
	private String question= null;
	
	private int days;
	
	private boolean status;
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public NewTicket(){
	}
	public NewTicket(String question, int days) {
		this.question = question;
		this.days = days;
	}

	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;

	}
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
		
	}

}
