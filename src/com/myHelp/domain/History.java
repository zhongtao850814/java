package com.myHelp.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class History {
	
	private Integer id;
	
	private Integer ticketID;
	
	private Date createTime;
	
	private Date resolveTime;

	private Employee createEmployee;
	
	private Employee resolveEmployee;

	public History() {
		
	}
	

	public History(Integer id, Integer ticketID, Date createTime,
			Date resolveTime, Employee createEmployee, Employee resolveEmployee) {
		super();
		this.id = id;
		this.ticketID = ticketID;
		this.createTime = createTime;
		this.resolveTime = resolveTime;
		this.createEmployee = createEmployee;
		this.resolveEmployee = resolveEmployee;
	}


	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "TICKET_ID")
	public Integer getTicketID() {
		return ticketID;
	}

	public void setTicketID(Integer ticketID) {
		this.ticketID = ticketID;
	}


	@Column(name = "CREATE_TIME")
	@Temporal(TemporalType.DATE)
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "RESOLVE_TIME")
	@Temporal(TemporalType.DATE)
	public Date getResolveTime() {
		return resolveTime;
	}

	public void setResolveTime(Date resolveTime) {
		this.resolveTime = resolveTime;
	}
	
	@ManyToOne
	@JoinColumn(name = "CREATE_ID", referencedColumnName="ID")
	public Employee getCreateEmployee() {
		return createEmployee;
	}

	public void setCreateEmployee(Employee createEmployee) {
		this.createEmployee = createEmployee;
	}

	@ManyToOne
	@JoinColumn(name = "RESOLVE_ID", referencedColumnName="ID")
	public Employee getResolveEmployee() {
		return resolveEmployee;
	}

	public void setResolveEmployee(Employee resolveEmployee) {
		this.resolveEmployee = resolveEmployee;
	}
	
	

}
