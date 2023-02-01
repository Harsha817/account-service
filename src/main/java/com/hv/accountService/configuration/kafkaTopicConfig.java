package com.hv.accountService.configuration;

//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.apache.kafka.clients.admin.NewTopic;

@Configuration
public class kafkaTopicConfig {

	
	public  NewTopic salaryTopic() {
		return TopicBuilder.name("salary").build();
	}
}
