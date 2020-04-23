package com.rest.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rest.soap.client.RestSoapConsumer;

@SpringBootApplication
public class RestSoapClientApplication implements CommandLineRunner{
	@Autowired
	RestSoapConsumer restSoapConsumer;
	public static void main(String[] args) {
		SpringApplication.run(RestSoapClientApplication.class, args);
		
		
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		restSoapConsumer.consumeRestGetLimit();
		
		
	}
	

}
