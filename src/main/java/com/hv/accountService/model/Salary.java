package com.hv.accountService.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@Document
public class Salary {

	@Id
    private String empId;
    private Number amount;
    private Number yearMonth;
	
    public Salary() {
	
    }

	public Salary(SalaryBuilder builder) {
		this.empId = builder.empId;
		this.amount = builder.amount;
		this.yearMonth = builder.yearMonth;
	}

	public String getEmpId() {
		return empId;
	}

	public Number getAmount() {
		return amount;
	}

	public Number getYearMonth() {
		return yearMonth;
	}

	@Override
	public String toString() {
		return "Salary [empId=" + empId + ", amount=" + amount + ", yearMonth=" + yearMonth + "]";
	}
	
	@JsonPOJOBuilder(withPrefix = "set")
    public static class SalaryBuilder {
        protected String empId;
        protected Number yearMonth;
        protected Number amount;

        public SalaryBuilder setEmpId(String empId) {
            this.empId = empId;
            return this;
        }

        public SalaryBuilder setYearMonth(Number yearMonth) {
            this.yearMonth = yearMonth;
            return this;
        }

        public SalaryBuilder setAmount(Number amount) {
            this.amount = amount;
            return this;
        }

        public Salary build() {
            return new Salary(this);
        }
    }

    
    
    
}
