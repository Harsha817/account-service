package kafka;

import org.springframework.stereotype.Service;
import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.slf4j.Logger;

@Service
public class kafkaProducer {

	
	private static final Logger Logger = LoggerFactory.getLogger(kafkaProducer.class);
	
	private KafkaTemplate<String,String> kafkaTemplate;

	public kafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	
	public void sendMessage(String message) {
		Logger.info(String.format("Message sent %s", message));
		kafkaTemplate.send("salaryTopic",message );
		
	}
}
