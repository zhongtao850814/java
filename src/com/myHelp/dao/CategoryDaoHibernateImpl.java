package com.myHelp.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.myHelp.domain.TicketCategory;
import com.myHelp.utils.HibernateUtils;
@Repository("categoryDao")
public class CategoryDaoHibernateImpl implements CategoryDao{


	@Override
	public void updateCategory(TicketCategory ticketCategory) {
		Session session = HibernateUtils.getSession();
		Transaction t = session.beginTransaction();
		session.update(ticketCategory);
		t.commit();
		session.close();
	}

	@Override
	public void addCategory(TicketCategory ticketCategory) {
		Session session = HibernateUtils.getSession();
		Transaction t = session.beginTransaction();
		session.save(ticketCategory);
		t.commit();
		session.close();
	}



}
