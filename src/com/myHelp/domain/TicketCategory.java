package com.myHelp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "TICKET_CATEGORY")
public class TicketCategory {
	
	private int ticketCategoryID;
	
	private String name;
	
	private String description;
	
	private Ticket ticket;

	public TicketCategory() {
		
	}
	
	public TicketCategory(int ticketCategoryID, String name, String discription) {
		super();
		this.ticketCategoryID = ticketCategoryID;
		this.name = name;
		this.description = discription;
	}

	@Id
	@GeneratedValue(generator = "generator")
    @GenericGenerator(strategy = "foreign", name="generator",
            parameters = @Parameter(name = "property", value="ticket"))
    @Column(name = "TICKET_CATEGORY_ID")
	public int getTicketCategoryID() {
		return ticketCategoryID;
	}

	public void setTicketCategoryID(int ticketCategoryID) {
		this.ticketCategoryID = ticketCategoryID;
	}

	@Column
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "DESCRIBE")
	public String getDiscription() {
		return description;
	}

	public void setDiscription(String discription) {
		this.description = discription;
	}
	
	

}
