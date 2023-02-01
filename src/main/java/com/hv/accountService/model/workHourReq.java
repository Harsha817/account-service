package com.hv.accountService.model;



public class workHourReq {
	private String empId;
    private Number yearMonth;
	
    
    
    public workHourReq() {
		
	}



	public workHourReq(String empId, Number yearMonth) {
		super();
		this.empId = empId;
		this.yearMonth = yearMonth;
	}



	public String getEmpId() {
		return empId;
	}



	public Number getYearMonth() {
		return yearMonth;
	}
}
