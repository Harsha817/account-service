package com.hv.accountService.model;

public class workHour {
	private String empId;
	private Number yearMonth;
	private Number count;
	
	
	
	
	
	public workHour() {
		
	}





	public workHour(String empId, Number yearMonth, Number count) {
		super();
		this.empId = empId;
		this.yearMonth = yearMonth;
		this.count = count;
	}





	public String getEmpId() {
		return empId;
	}





	public Number getYearMonth() {
		return yearMonth;
	}





	public Number getCount() {
		return count;
	}
}
