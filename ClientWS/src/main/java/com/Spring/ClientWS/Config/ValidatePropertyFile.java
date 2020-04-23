package com.Spring.ClientWS.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:SoapResponseValidate.properties")
public class ValidatePropertyFile {
	
	@Value("${app1_service1_soap_response_validate}")
	public String app1_service1_soap_response_validate;
	
	@Value("${app1_service1_soap_response_validate_GetCountryResponse}")
	public String app1_service1_soap_response_validate_GetCountryResponse;

}
