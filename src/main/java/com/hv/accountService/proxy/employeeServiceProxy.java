package com.hv.accountService.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hv.accountService.model.Employee;


@FeignClient(name = "Employee-Service")
public interface employeeServiceProxy {
	@GetMapping("/api/employee/{id}")
    public static Employee getEmployee(@PathVariable String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
