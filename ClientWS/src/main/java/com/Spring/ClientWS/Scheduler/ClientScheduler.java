package com.Spring.ClientWS.Scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.Spring.ClientWS.Client.WsClient;

@Component
@EnableScheduling
public class ClientScheduler {

	@Autowired
	WsClient client;
	
	private static final Logger log = org.slf4j.LoggerFactory.getLogger(ClientScheduler.class);
	
	private static final SimpleDateFormat dateformat = new SimpleDateFormat("HH:mm:ss");
	
	@Scheduled(fixedRate = 5000)
	public void invokeClient() {
		client.invokeClient();
	}
}
