package com.myHelp.dao;


import java.util.List;

import com.myHelp.domain.Ticket;



public interface TicketDao {
	
	public Ticket getTicket(int id);
	
	public List<Ticket> getTickets();
	
	public void addTicket(Ticket ticket);
	
	public void deleteTicket(int id);
	
	public void updateTicket(Ticket ticket);
	
	public int getNumberOfTickets();
	
	public List<Ticket> getOpenTickets();
}
