package com.Spring.ClientWS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.ClientWS.Client.WsClient;
import com.Spring.ClientWS.TimeCheck.TimeCheck;
import com.Spring.ClientWS.TimeCheck.TimeCheckAPI2;
import com.Spring.ClientWS.TimeCheck.TimeCheckAPI3;
import com.Spring.ClientWS.TimePercentage.UpTimePercent;
import com.Spring.ClientWS.TimeRepository.TimeRepository;

@org.springframework.stereotype.Controller
public class Controller {

	
	@Autowired
	WsClient client;
	@Autowired
	TimeRepository repo;
	
	
	long UpTimePercentApi1=0,UpTimePercentApi2=0,UpTimePercentApi3=0;

	
	@RequestMapping("Dashboard")
	public String backToDashboard(Model model) {
		model.addAttribute("StatusCodeAPI1", client.StatusCodeAPI1);
		model.addAttribute("StatusCodeAPI2", client.StatusCodeAPI2);
		model.addAttribute("StatusCodeAPI3", client.StatusCodeAPI3);
		model.addAttribute("statusCodeGetLimitRestApi", client.statusCodeGetLimitRestApi);
		model.addAttribute("statusCodeCreasteSessionRestApi", client.statusCodeCreasteSessionRestApi);

		model.addAttribute("UptimeAPI1", repo.getUpTimeForApi1().get(repo.getUpTimeForApi1().size()-1));
		model.addAttribute("UptimeAPI2", repo.getUpTimeForApi2().get(repo.getUpTimeForApi2().size()-1));
		model.addAttribute("UptimeAPI3", repo.getUpTimeForApi3().get(repo.getUpTimeForApi3().size()-1));
//		UpTimePercentApi1=upTimePercent.upTimePercent(timeCheck.upTimeAPI1.getSeconds(), timeCheck.downDateAPI1.getSeconds());
		model.addAttribute("UpTimePercentApi1",UpTimePercentApi1);
		
		model.addAttribute("downtimeAPI1", repo.getDownTimeForApi1().get(repo.getDownTimeForApi1().size()-1));
		model.addAttribute("downtimeAPI2", repo.getDownTimeForApi2().get(repo.getDownTimeForApi2().size()-1));
		model.addAttribute("downtimeAPI3", repo.getDownTimeForApi3().get(repo.getDownTimeForApi3().size()-1));
		return "ViewPage";
		
	}
}
