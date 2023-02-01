package com.hv.accountService.model;

import java.util.Date;

public class Employee {
	private String id;
	private String name;
	private String deptName;
	private String address;
	private Date joiningDate;
	private Number baseSalary;
	
	
	
	
	public Employee() {
		
	}


	public Employee(String id, String name, String deptName, String address, Date joiningDate, int baseSalary) {
		super();
		this.id = id;
		this.name = name;
		this.deptName = deptName;
		this.address = address;
		this.joiningDate = joiningDate;
		this.baseSalary = baseSalary;
	}


	public String getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public String getDeptName() {
		return deptName;
	}


	public String getAddress() {
		return address;
	}


	public Date getJoiningDate() {
		return joiningDate;
	}


	public Number getBaseSalary() {
		return baseSalary;
	}
}
