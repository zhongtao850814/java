package com.myHelp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.myHelp.domain.History;
import com.myHelp.utils.HibernateUtils;



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

}
