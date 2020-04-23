package com.Spring.ClientWS.Config;

import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.Spring.ClientWS.BindingClasses.CustomerRequest;
import com.Spring.ClientWS.BindingClasses.GetCountryRequest;
import com.Spring.ClientWS.Client.WsClient;
import com.Spring.ClientWS.TimeCheck.TimeCheck;
import com.Spring.ClientWS.TimeCheck.TimeCheckAPI2;
import com.Spring.ClientWS.TimeCheck.TimeCheckAPI3;
import com.Spring.ClientWS.TimePercentage.UpTimePercent;
import com.Spring.ClientWS.TimeRepository.TimeRepository;

@org.springframework.context.annotation.Configuration
public class Configuration {
	@Autowired
	Jaxb2Marshaller marshaller;
	@Autowired
	LoadingPropFile prop;

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setPackagesToScan("com.Spring.ClientWS.BindingClasses");
		return marshaller;
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public CustomerRequest request() {
		CustomerRequest request = new CustomerRequest();
		request.setAge(prop.setAge);
		request.setCibilScore(700);
		request.setCustomerName("Utkarsh");
		request.setSalary(25000);

		return request;
	}

	@Bean
	public WebServiceTemplate Template() {
		return new WebServiceTemplate(marshaller);
	}

	@Bean(name = "client")
	public WsClient wsClient() {
		return new WsClient();
	}

	@Bean
	public GetCountryRequest countryRequest() {
		GetCountryRequest request = new GetCountryRequest();
		request.setName("Spain");
		return request;
	}

	@Bean(name = "time")
	public TimeCheck timeCheck() {
		return new TimeCheck();
	}

	@Bean(name = "timeCheckForAPI2")
	public TimeCheckAPI2 timeCheckAPI2() {
		return new TimeCheckAPI2();
	}

	@Bean
	public LoadingPropFile prop() {
		return new LoadingPropFile();
	}

	@Bean(name = "timeCheckForAPI3")
	public TimeCheckAPI3 timeCheckAPI3() {
		return new TimeCheckAPI3();
	}
	@Bean(name="timePercent")
	public UpTimePercent upTimePercent() {
		return new UpTimePercent();
	}
	
	
	public TimeRepository repository() {
		return new TimeRepository();
	}
}
