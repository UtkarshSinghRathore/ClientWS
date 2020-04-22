package com.appMonitoringService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppResource {
	@RequestMapping("monitoringGetLimits")
public List<App> getDetails()
{
	List<App> appRes = new ArrayList<App>();
	App app = new App();
	app.setId(1);
	app.setUrl("https://www.westernunion.com/wuconnect/rest/api/v2.0/GetLimits?timestamp=1586256316830");
	
	appRes.add(app);
	
	return appRes;
}
}