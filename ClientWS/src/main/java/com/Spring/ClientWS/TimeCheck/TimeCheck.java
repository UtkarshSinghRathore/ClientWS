package com.Spring.ClientWS.TimeCheck;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.CodeFlow.ClinitAdder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import com.Spring.ClientWS.Client.WsClient;
import com.Spring.ClientWS.TimeRepository.TimeRepository;

import ch.qos.logback.core.net.server.Client;

@Component
public class TimeCheck {
	
	@Autowired
	WsClient client;
	@Autowired
	TimeRepository repository;
	
	int flagAPI1=0;
	
	public Date downDateAPI1, upTimeAPI1;
	
	 public void timeCheck() {
		if(client.StatusCodeAPI1!=200) {
			if(flagAPI1==1)
			{
				downDateAPI1=new Date();
				repository.setDownTimeForApi1(downDateAPI1);
//				System.out.println(downDateAPI1);
				flagAPI1=0;
			}
		}
		if(client.StatusCodeAPI1==200) {
			if(flagAPI1==0) {
				upTimeAPI1 = new Date();
				repository.setUpTimeForApi1(upTimeAPI1);
//				System.out.println(upTimeAPI1);
				flagAPI1=1;
			}
		}
//		if(client.StatusCodeAPI2!=200) {
//			if(flagAPI2==1)
//			{
//				downDateAPI2=new Date();
//				System.out.println(downDateAPI2);
//				flagAPI2=0;
//			}
//		}
//		if(client.StatusCodeAPI2==200) {
//			if(flagAPI2==0) {
//				upTimeAPI2 = new Date();
//				System.out.println(upTimeAPI2);
//				flagAPI2=1;
//			}
//		}
	}
//	public void getdelayTime() {
//		System.out.println();
//	}

}
