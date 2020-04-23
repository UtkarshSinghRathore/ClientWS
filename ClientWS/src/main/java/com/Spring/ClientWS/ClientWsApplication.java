package com.Spring.ClientWS;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.Spring.ClientWS.Client.WsClient;
import com.Spring.ClientWS.Config.LoadingPropFile;
import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;

@SpringBootApplication
public class ClientWsApplication {

	
	
	public static void main(String[] args) {
		
		SpringApplication.run(ClientWsApplication.class, args);
	
	
	
	}

}
