package com.myHelp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.myHelp.domain.User;
import com.myHelp.utils.HibernateUtils;



@Repository("userDao")
public class UserDaoHibernateImpl implements UserDao {

	@Override
	public User getUser(int id) {
		Session session = HibernateUtils.getSession();
		Transaction t = session.beginTransaction();
		User u = (User) session.get(User.class, id);
		t.commit();
		session.close();
		return u;
	}

	@Override
	public List<User> getUsers() {
		Session session = HibernateUtils.getSession();
		Transaction t = session.beginTransaction();
		Query q = session.createQuery("from User");
		List<User> list = q.list();
		t.commit();
		session.close();
		return list;
	}

	@Override
	public void addUser(User user) {
		Session session = HibernateUtils.getSession();
		Transaction t = session.beginTransaction();
		session.save(user);
		t.commit();
		session.close();
	}
	
	@Override
	public void deleteUser(int id) {
		Session session = HibernateUtils.getSession();
		Transaction t = session.beginTransaction();
		User u = (User) session.get(User.class, id);
		session.delete(u);
		t.commit();
		session.close();

	}

	@Override
	public void updateUser(User user) {
		Session session = HibernateUtils.getSession();
		Transaction t = session.beginTransaction();
		session.update(user);
		t.commit();
		session.close();

	}

	@Override
	public int getNumberOfUsers() {
		Session session = HibernateUtils.getSession();
		Query q = session.createQuery("select count(*) from User");
		List<Integer> counts = q.list();
		session.close();
		return new Integer("" + counts.get(0));
	}

	@Override
	public boolean checkUser(String username, String password) {
		// TODO Auto-generated method stub
		Session session = HibernateUtils.getSession();
		session.close();

		return false;
	}

}
