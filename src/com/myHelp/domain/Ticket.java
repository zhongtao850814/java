package com.myHelp.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Ticket {
	
	private int id;
	
	private String question;
	
	private String answer;
	
	private int maxResponseTime;
	
	private boolean state;
	
	private TicketCategory ticketCategory;

	public Ticket() {
		
	}
	
	public Ticket(String question, String answer, int maxResponseTime,
			boolean state) {
		super();
		this.id = id;
		this.question = question;
		this.answer = answer;
		this.maxResponseTime = maxResponseTime;
		this.state = state;
		this.ticketCategory = ticketCategory;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	@Column
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Column(name = "MAX_REPONSE_TIME")
	public int getMaxResponseTime() {
		return maxResponseTime;
	}

	public void setMaxResponseTime(int maxResponseTime) {
		this.maxResponseTime = maxResponseTime;
	}

	@Column(name = "STATE")
	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	@OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
	public TicketCategory getTicketCategory() {
		return ticketCategory;
	}

	public void setTicketCategory(TicketCategory ticketCategory) {
		this.ticketCategory = ticketCategory;
	}
	
	
	
	

	
}
