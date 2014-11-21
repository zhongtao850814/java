package com.myHelp.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.myHelp.domain.Ticket;
import com.myHelp.utils.HibernateUtils;



@Repository("ticketDao")
public class TicketDaoHibernateImpl implements TicketDao {

	@Override
	public Ticket getTicket(int id) {
		Session session = HibernateUtils.getSession();
		Transaction t = session.beginTransaction();
		Ticket ticket = (Ticket) session.get(Ticket.class, id);
		t.commit();
		session.close();
		return ticket;
	}

	@Override
	public List<Ticket> getTickets() {
		Session session = HibernateUtils.getSession();
		Transaction t = session.beginTransaction();
		Query q = session.createQuery("from Ticket");
		List<Ticket> list = q.list();
		t.commit();
		session.close();
		return list;
	}
	
	@Override
	public void addTicket(Ticket ticket) {
		Session session = HibernateUtils.getSession();
		Transaction t = session.beginTransaction();
		session.save(ticket);
		t.commit();
		session.close();

	}

	@Override
	public void deleteTicket(int id) {
		Session session = HibernateUtils.getSession();
		Transaction t = session.beginTransaction();
		Ticket ticket = (Ticket) session.get(Ticket.class, id);
		session.delete(ticket);
		t.commit();
		session.close();

	}

	@Override
	public void updateTicket(Ticket ticket) {
		Session session = HibernateUtils.getSession();
		Transaction t = session.beginTransaction();
		session.update(ticket);
		t.commit();
		session.close();

	}

	@Override
	public int getNumberOfTickets() {
		Session session = HibernateUtils.getSession();
		Query q = session.createQuery("select count(*) from Ticket");
		List<Integer> counts = q.list();
		session.close();
		return new Integer("" + counts.get(0));
	}

	@Override
	public List<Ticket> getOpenTickets() {
		Session session = HibernateUtils.getSession();
		Query q = session.createQuery("from Ticket as ticket where ticket.state = true");
		List<Ticket> openTickets = q.list();
		session.close();
		return openTickets;
	}


}
