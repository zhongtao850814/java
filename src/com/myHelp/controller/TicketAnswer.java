package com.myHelp.controller;

public class TicketAnswer {
	private int id = 0;
	private String answer= null;
	
	public TicketAnswer(){
		
	}
	
	public TicketAnswer(int id, String answer){
		this.id = id;
		this.answer = answer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
