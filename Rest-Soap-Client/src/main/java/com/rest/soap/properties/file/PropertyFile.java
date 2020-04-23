package com.rest.soap.properties.file;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("classpath:config.properties")
@Component
public class PropertyFile {
	
	@Value("${app1_service3_soap}")
	public String app1_service3_soapL;
	
	@Value("${app2_service1_soap}")
	public String app2_service1_soap;
	
	

	@Value("${app1_service1_rest}")
	public String app1_service1_rest;
	
	@Value("${app1_service2_rest}")
	public String app1_service2_rest;

}
