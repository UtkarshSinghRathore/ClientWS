package com.Spring.ClientWS.Controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Spring.ClientWS.Client.WsClient;
import com.Spring.ClientWS.TimePercentage.UpTimePercent;
import com.Spring.ClientWS.TimeRepository.TimeRepository;

@Controller
public class GetLoanEligibiltyController {
	
	@Autowired
	WsClient client;
	@Autowired
	TimeRepository repo;
	@Autowired
	UpTimePercent upTimePercent;
	
	@RequestMapping("GetLoanEligibilty")
	public String grtLoanEligibiltyView(Model m) {
		
		double UptimePercent = upTimePercent.upTimePercent();
		
		m.addAttribute("UptimePercent", UptimePercent);
		
		return "GetLoanEligibilty";
		
	}

}
