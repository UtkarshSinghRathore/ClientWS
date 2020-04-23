package com.rest.soap.properties.file;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:ServiceResponseCode.properties")
public class ServiceResponseCodePropertyLoader 
{
//	@Value("${app1_service1_rest_response_code_response_body}")
//	public String app1_service1_rest_response_code_response_body;
//	
//	@Value("${app1_service2_rest_response_code_response_body}")
//	public String app1_service2_rest_response_code_response_body;
	//Create Session
	@Value("${app1_service1_rest_response_code_id}")
	public String app1_service1_rest_response_code_id;
	
	@Value("${app1_service1_rest_response_code_url}")
	public String app1_service1_rest_response_code_url;
	
	@Value("${app1_service1_rest_response_code_status}")
	public String app1_service1_rest_response_code_status;
	//get limit
	@Value("${app1_service2_rest_response_code_id}")
	public String app1_service2_rest_response_code_id;
	
	@Value("${app1_service2_rest_response_code_url}")
	public String app1_service2_rest_response_code_url;
	
	@Value("${app1_service2_rest_response_code_status}")
	public String app1_service2_rest_response_code_status;
}
