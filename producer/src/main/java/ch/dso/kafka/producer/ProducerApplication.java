package ch.dso.kafka.producer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProducerApplication {


	@Value("${topic.partitions-num}")
	private Integer partitions;

	@Value("${topic.replication-factor}")
	private short replicationFactor;


	@Bean
	NewTopic usersTopic() {
		return new NewTopic("user", partitions, replicationFactor);
	}


	//POUR TESTS UNE PARTITION
	@Bean
	NewTopic usersOnePartitionTopic() {
		return new NewTopic("user-one-p", 1, (short)1);
	}

	@Bean
	NewTopic messageTopic() {
		return new NewTopic("message", partitions, replicationFactor);
	}

	@Bean
	NewTopic carTopic() {
		return new NewTopic("car", partitions, replicationFactor);
	}


	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}

}
