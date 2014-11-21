package com.myHelp.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Employee {

	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private User user;
	
	private List<History> createHistorys;
	
	private List<History> resolveHistorys;

	public Employee() {
		
	}

	
	public Employee(int id, String firstName, String lastName) {
		super();
		this.id=id;
		this.firstName = firstName;
		this.lastName = lastName;
	}


	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "First_Name")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "Last_Name")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "createEmployee", cascade = CascadeType.ALL)
	public List<History> getCreateHistorys() {
		return createHistorys;
	}

	public void setCreateHistorys(List<History> createHistorys) {
		this.createHistorys = createHistorys;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "resolveEmployee", cascade = CascadeType.ALL)
	public List<History> getResolveHistorys() {
		return resolveHistorys;
	}
	
	public void setResolveHistorys(List<History> resolveHistorys) {
		this.resolveHistorys = resolveHistorys;
	}
	
	
	
	
}
