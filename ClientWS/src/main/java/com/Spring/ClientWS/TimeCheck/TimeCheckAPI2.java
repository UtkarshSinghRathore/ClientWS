package com.Spring.ClientWS.TimeCheck;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Spring.ClientWS.Client.WsClient;
import com.Spring.ClientWS.TimeRepository.TimeRepository;

@Component
public class TimeCheckAPI2 {
	
	@Autowired
	WsClient client;
	@Autowired
	TimeRepository repo;
	
	int FlagAPI2=1;
	
	public Date UpTimeAPI2, DownTimeAPI2;
	
	public void timeCheckAPI2() {
		if(client.StatusCodeAPI2!=200) {
			if(FlagAPI2==0) {
				DownTimeAPI2 = new Date();
				repo.setDownTimeForApi2(DownTimeAPI2);
				FlagAPI2=1;
			}
		}
		if(client.StatusCodeAPI2==200) {
			if(FlagAPI2==1) {
				UpTimeAPI2=new Date();
				repo.setUpTimeForApi2(UpTimeAPI2);
				FlagAPI2=0;
			}
		}
		
	}
	

}
