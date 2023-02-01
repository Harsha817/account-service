package com.hv.accountService.configuration;

import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;

public class CouchConfig extends  AbstractCouchbaseConfiguration{

	@Override
	public String getConnectionString() {
		return "couchbase://127.0.0.1";
	}

	@Override
	public String getUserName() {
		return "admin";
	}

	@Override
	public String getPassword() {
		return "Harsha";
	}

	@Override
	public String getBucketName() {
		return "AccountService";
	}

}
