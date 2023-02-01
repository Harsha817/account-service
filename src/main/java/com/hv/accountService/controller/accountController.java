package com.hv.accountService.controller;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hv.accountService.model.Salary;
//import com.hv.accountService.model.workHourReq;
import com.hv.accountService.service.accountService;

@RestController
@RequestMapping("/account")
public class accountController {
	@Autowired
    private accountService AccountService;
    
	

    Logger logger = LoggerFactory.getLogger(accountController.class);

    @GetMapping("/calculateSalary/{employeeId}/{yearMonth}")
    @CircuitBreaker(name = "employeeAndWorkHourBreaker", fallbackMethod = "employeeAndWorkHourFallback")
    public Salary calculateSalary(@PathVariable String employeeId, @PathVariable Number yearMonth){
        return this.AccountService.calculateSalary(employeeId,yearMonth);
    }

    public Salary employeeAndWorkHourFallback(String employeeId, Number yearMonth, Exception ex){
        logger.info("Fallback is executed because one the services is down: ");
        logger.info(ex.getMessage());
        Number baseSalary = 20000;
        Salary salary = new Salary.SalaryBuilder()
                .setEmpId(employeeId)
                .setYearMonth(yearMonth)
                .setAmount(baseSalary)
                .build();

        return salary;
    }
}
