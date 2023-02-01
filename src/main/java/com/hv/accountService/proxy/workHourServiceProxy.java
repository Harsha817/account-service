package com.hv.accountService.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;

import com.hv.accountService.model.workHour;
//import com.hv.accountService.model.workHourReq;

import java.util.Optional;

@FeignClient(name = "WorkHour-Service")
public interface workHourServiceProxy {
	 @GetMapping("/req")
	    public Optional<workHour> getEmployeeLeaveByEmpIdAndYearMonth(@PathVariable String employeeId, @PathVariable Number yearMonth);
}
