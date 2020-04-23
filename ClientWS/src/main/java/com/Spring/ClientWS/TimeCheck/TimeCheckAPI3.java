package com.Spring.ClientWS.TimeCheck;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.Spring.ClientWS.Client.WsClient;
import com.Spring.ClientWS.TimeRepository.TimeRepository;

public class TimeCheckAPI3 {
	@Autowired
	WsClient client;
	@Autowired
	TimeRepository repo;
	
	int FlagAPI3=1;
	
	public Date UpTimeAPI3, DownTimeAPI3;
	
	public void timeCheckAPI3() {
		if(client.StatusCodeAPI3!=200) {
			if(FlagAPI3==0) {
				DownTimeAPI3 = new Date();
				repo.setDownTimeForApi3(DownTimeAPI3);
				FlagAPI3=1;
			}
		}
		if(client.StatusCodeAPI3==200) {
			if(FlagAPI3==1) {
				
				UpTimeAPI3=new Date();
				repo.setUpTimeForApi3(UpTimeAPI3);
				FlagAPI3=0;
			}
		}

	}
}
