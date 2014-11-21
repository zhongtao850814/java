package com.myHelp.dao;

import java.util.List;

import com.myHelp.domain.User;



public interface UserDao {

	public User getUser(int id);
	
	public List<User> getUsers();
	
	public void addUser(User user);
	
	public void deleteUser(int id);
	
	public void updateUser(User user);
	
	public int getNumberOfUsers();
	
	public boolean checkUser(String username, String password);
}
