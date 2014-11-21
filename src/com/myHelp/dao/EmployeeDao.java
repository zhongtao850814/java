package com.myHelp.dao;

import java.util.List;

import com.myHelp.domain.Employee;



public interface EmployeeDao {
	
	public Employee getEmployee(int id);
	
	public List<Employee> getEmployees();
	
	public void addEmployee(Employee employee);
	
	public void deleteEmployee(int id);
	
	public void updateEmployee(Employee employee);
	
	public int getNumberOfUsers();
	

}
