package com.appMonitoring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppBeanResource {
@RequestMapping("monitoringCreateSession")
public List<AppBean> getDetail()
{
	List<AppBean> list = new ArrayList<AppBean>();
	AppBean ab = new AppBean();
	ab.setSessionID(100);
	ab.setUrl("https://www.westernunion.com/wuconnect/rest/api/v2.0/CreateSession");
	
	list.add(ab);
	return list;

}
}
