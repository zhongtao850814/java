package com.myHelp.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.myHelp.domain.Employee;
import com.myHelp.utils.HibernateUtils;



@Repository("employeeDao")
public class EmployeeDaoHibernateImpl implements EmployeeDao {

	@Override
	public Employee getEmployee(int id) {
		Session session = HibernateUtils.getSession();
		Transaction t = session.beginTransaction();
		Employee e = (Employee) session.get(Employee.class, id);
		t.commit();
		session.close();
		return e;
	}

	@Override
	public List<Employee> getEmployees() {
		Session session = HibernateUtils.getSession();
		Transaction t = session.beginTransaction();
		Query q = session.createQuery("from Employee");
		List<Employee> list = q.list();
		t.commit();
		session.close();
		return list;
	}

	@Override
	public void addEmployee(Employee employee) {
		Session session = HibernateUtils.getSession();
		Transaction t = session.beginTransaction();
		session.save(employee);
		t.commit();
		session.close();
	}

	@Override
	public void deleteEmployee(int id) {
		Session session = HibernateUtils.getSession();
		Transaction t = session.beginTransaction();
		Employee e = (Employee) session.get(Employee.class, id);
		session.delete(e);
		t.commit();
		session.close();

	}

	@Override
	public void updateEmployee(Employee employee) {
		Session session = HibernateUtils.getSession();
		Transaction t = session.beginTransaction();
		session.update(employee);
		t.commit();
		session.close();
	}

	@Override
	public int getNumberOfUsers() {
		Session session = HibernateUtils.getSession();
		Query q = session.createQuery("select count(*) from Employee");
		List<Integer> counts = q.list();
		session.close();
		return new Integer("" + counts.get(0));
	}

}
