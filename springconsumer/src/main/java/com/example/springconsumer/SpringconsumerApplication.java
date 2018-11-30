package com.example.springconsumer;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.schema.avro.AvroSchemaMessageConverter;
import org.springframework.cloud.stream.schema.client.ConfluentSchemaRegistryClient;
import org.springframework.cloud.stream.schema.client.EnableSchemaRegistryClient;
import org.springframework.cloud.stream.schema.client.SchemaRegistryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.converter.MessageConverter;

@SpringBootApplication
//@EnableSchemaRegistryClient
public class SpringconsumerApplication {
	
	@Bean
	public MessageConverter userMessageConverter() throws IOException {
	      return new AvroSchemaMessageConverter();
	}
	
	@Bean
	public SchemaRegistryClient schemaRegistryClient(@Value("${spring.cloud.stream.schemaRegistryClient.endpoint}") String endpoint){
	  ConfluentSchemaRegistryClient client = new ConfluentSchemaRegistryClient();
	  client.setEndpoint(endpoint);
	  return client;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringconsumerApplication.class, args);
	}
	
	
	
}
