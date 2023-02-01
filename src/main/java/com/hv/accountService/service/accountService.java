package com.hv.accountService.service;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;

import com.hv.accountService.model.Salary;
import com.hv.accountService.model.workHour;
//import com.hv.accountService.model.workHourReq;
import com.hv.accountService.proxy.employeeServiceProxy;
import com.hv.accountService.proxy.workHourServiceProxy;
//import com.hv.accountService.repo.salaryRepo;
//import com.hv.accountService.repo.salaryRepo;

@Service
public class accountService {
	//@Autowired
    //private employeeServiceProxy empProxy;
    //@Autowired
    private workHourServiceProxy workHourProxy;
    //@Autowired
    //private RestTemplate restTemplate;

	//@Autowired
	//private salaryRepo SalaryRepo;

	public Salary calculateSalary(String employeeId, Number yearMonth) {
        Salary salary;
        Number amount = null;

        Number baseSalary = employeeServiceProxy.getEmployee(employeeId).getBaseSalary();
//            EmployeeLeave leave = restTemplate
//                    .getForObject("http://localhost:8085/employeeleave/find/{employeeId}/{yearMonth}",EmployeeLeave.class, employeeId, yearMonth);
            workHour leave =
                     workHourProxy
                            .getEmployeeLeaveByEmpIdAndYearMonth(employeeId,yearMonth)
                            .get();
            if(leave == null){
                amount = baseSalary;
            }else {
                Number leaveCount = leave.getCount();
                Number daysInMonth = calculateDaysInMonth(yearMonth);
                amount = (baseSalary.intValue()) * (daysInMonth.intValue() - leaveCount.intValue()) / daysInMonth.intValue();
            }

        salary = new Salary.SalaryBuilder()
                .setEmpId(employeeId)
                .setYearMonth(yearMonth)
                .setAmount(amount)
                .build();

//        salaryEntityRepository.save(salary);

        return salary;
    }

    private Number calculateDaysInMonth(Number yearMonth) {
        int year = Integer.parseInt(("" + yearMonth.intValue()).substring(0, 4));
        int month = yearMonth.intValue() % 100;
        return getDays(year,month);
    }

    private Number getDays(int year, int month){
        if (month == 2) {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
                return 29;
            return 28;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11)
            return 30;
        return 31;
    }		
}
