package com.Spring.ClientWS.TimePercentage;

import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Spring.ClientWS.TimeRepository.TimeRepository;

@Component
public class UpTimePercent {
	
	@Autowired
	TimeRepository repo;

	
	public double upTimePercent() {
		double total_uptime_percent, total_uptime=0;
		for(int i=0;i<repo.getDownTimeForApi1().size();i++) {
			total_uptime=total_uptime+(repo.getDownTimeForApi1().get(i).getTime()-repo.getUpTimeForApi1().get(i).getTime());
		}
		if (total_uptime < 0) {
			throw new IllegalStateException("Downtime shold be greater than uptime");
		} else {
			total_uptime_percent = (total_uptime) / 86400000 * 100;
			total_uptime_percent = (double) Math.round(total_uptime_percent * 100) / 100;
		}
		return total_uptime_percent;

	}
}
