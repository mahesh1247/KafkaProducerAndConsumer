package com.example.springproducer;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.schema.avro.AvroSchemaMessageConverter;
import org.springframework.cloud.stream.schema.client.ConfluentSchemaRegistryClient;
import org.springframework.cloud.stream.schema.client.EnableSchemaRegistryClient;
import org.springframework.cloud.stream.schema.client.SchemaRegistryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.stereotype.Service;

import com.kafka.demo.TestAvro;
import com.kafka.demo.TestAvro.Builder;



@SpringBootApplication
//@EnableSchemaRegistryClient
public class SpringproducerApplication {
	
//	
//	@Bean
//	public MessageConverter userMessageConverter() throws IOException {
//	      return new AvroSchemaMessageConverter();
//	}
	
	@Bean
	public SchemaRegistryClient schemaRegistryClient(@Value("${spring.cloud.stream.schemaRegistryClient.endpoint}") String endpoint){
	  ConfluentSchemaRegistryClient client = new ConfluentSchemaRegistryClient();
	  client.setEndpoint(endpoint);
	  return client;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringproducerApplication.class, args);
	}
	
	
	@Service
	@EnableBinding(Source.class)
	class Runner implements CommandLineRunner{
		
		@Autowired
		@Qualifier ( "output")
		MessageChannel channel;

		@Override
		public void run(String... args) throws Exception {
			Builder b =TestAvro.newBuilder();
			b.setIdentifier("12345111111111114");
			b.setUser("abcert");
			
			MessageBuilder<TestAvro> test = MessageBuilder.withPayload(b.build());
			System.out.println("Printing Message-------- "+test.getPayload() );
			channel.send(test.build());
		}
		
	}
}
