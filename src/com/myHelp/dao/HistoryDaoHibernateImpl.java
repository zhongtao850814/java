package com.myHelp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.myHelp.domain.Employee;
import com.myHelp.domain.History;
import com.myHelp.domain.Ticket;
import com.myHelp.utils.HibernateUtils;


@Repository("historyDao")
public class HistoryDaoHibernateImpl implements HistoryDao {

	@Override
	public List<History> getHistorys(int userID) {
		Session session = HibernateUtils.getSession();
		Transaction t = session.beginTransaction();
		Query q = session.createQuery("from History");
		List<History> list = q.list();
		t.commit();
		session.close();
		return list;
	}

	@Override
	public void addHistory(History history) {		
			Session session = HibernateUtils.getSession();
			Transaction t = session.beginTransaction();
			session.save(history);
			t.commit();
			session.close();
	}

	@Override
	public List<History> getHistory() {
		Session session = HibernateUtils.getSession();
		Transaction t = session.beginTransaction();
		Query q = session.createQuery("from History");
		List<History> list = q.list();
		t.commit();
		session.close();
		return list;
		
	}

	@Override
	public void updateHistory(History history) {
		Session session = HibernateUtils.getSession();
		Transaction t = session.beginTransaction();
		session.update(history);
		t.commit();
		session.close();	
	}


}
