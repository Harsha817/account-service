package com.hv.accountService.repo;

import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import com.hv.accountService.model.Salary;

@Repository
public interface salaryRepo extends CouchbaseRepository<Salary,String>{

}
