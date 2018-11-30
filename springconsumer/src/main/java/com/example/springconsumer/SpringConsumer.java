package com.example.springconsumer;

import org.apache.avro.generic.GenericRecord;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;

import com.kafka.demo.TestAvro;


@EnableBinding(Consumer.class)
public class SpringConsumer {
	@StreamListener(Consumer.INPUT)
	  public void messageListner(@Headers MessageHeaders messageHeaders,TestAvro message) {
		System.out.println("Consumed Messgae=================="+message);
	}
}
