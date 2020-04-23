package com.Spring.ClientWS.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:config.properties")
public class LoadingPropFile {

	@Value("${app1_service3_soap}")
	public String app1_service3_soapL;
	
	@Value("${app2_service1_soap}")
	public String app2_service1_soap;
	
	@Value("${API3_url}")
	public String API3_url;

	@Value("${app1_service1_rest}")
	public String app1_service1_rest;
	
	@Value("${app1_service2_rest}")
	public String app1_service2_rest;
	
	@Value("${setAge}")
	public int setAge;
	
	@Value("{misMatch}")
	public String misMatch;
	
//	@Value("${app1_service1_soap_response_validate_isEligible}")
//	public String app1_service1_soap_response_validate_isEligible;
//	
//	@Value("${app1_service1_soap_response_validate_approvedAmount}")
//	public String app1_service1_soap_response_validate_approvedAmount;
//	
//	@Value("${app1_service1_soap_response_validate_misMatchCriteria}")
//	public String app1_service1_soap_response_validate_misMatchCriteria;
	
	
}

