package com.Spring.ClientWS.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.Spring.ClientWS.BindingClasses.Acknowledgement;
import com.Spring.ClientWS.BindingClasses.CustomerRequest;
import com.Spring.ClientWS.BindingClasses.GetCountryRequest;
import com.Spring.ClientWS.BindingClasses.GetCountryResponse;
import com.Spring.ClientWS.Config.LoadingPropFile;
import com.Spring.ClientWS.Config.ValidatePropertyFile;
import com.Spring.ClientWS.TimeCheck.TimeCheck;
import com.Spring.ClientWS.TimeCheck.TimeCheckAPI2;
import com.Spring.ClientWS.TimeCheck.TimeCheckAPI3;

public class WsClient {

	@Autowired
	private RestTemplate RestTemplate;

	@Autowired
	TimeCheck timeCheck;

	@Autowired
	private Jaxb2Marshaller marshaller;

	@Autowired(required = true)
	private CustomerRequest request;

	@Autowired
	private TimeCheckAPI2 timeCheckAPI2;

	@Autowired
	private GetCountryRequest CountryRequest;

	@Autowired
	WebServiceTemplate webServiceTemplate;

	@Autowired
	LoadingPropFile prop;
	
	@Autowired
	ValidatePropertyFile validatePropertyFile;
	
	@Autowired
	GetLimitRestApiClient consumer;
	
	@Autowired
	RestCreateSessionConsumer restCreateSessionConsumer;
	
	@Autowired
	private TimeCheckAPI3 timeCheckAPI3;

	public int StatusCodeAPI1, StatusCodeAPI2, StatusCodeAPI3,statusCodeGetLimitRestApi,statusCodeCreasteSessionRestApi;
	public void invokeClient() {

		try {

			Acknowledgement acknowledgement = (Acknowledgement) webServiceTemplate.marshalSendAndReceive(prop.app1_service3_soapL,
					request);
			//System.out.println(acknowledgement.toString());
					
			if(validatePropertyFile.app1_service1_soap_response_validate.equals(acknowledgement.toString())) {
				System.out.println("Acknowledgement Api Up");
			}
			else {
				System.out.println("Acknowledgement Api Down");
			}
			
		} catch (Exception e) {
			StatusCodeAPI1 = 404;

		}
		try {
			GetCountryResponse response = (GetCountryResponse) webServiceTemplate.marshalSendAndReceive(prop.app2_service1_soap,
					CountryRequest);
			//System.out.println(response.toString());
			if(validatePropertyFile.app1_service1_soap_response_validate_GetCountryResponse.equals(response.toString())) {
				System.out.println("GetCountryResponse Api Up");
			}
			else {
				System.out.println("GetCountryResponse Api Down");
			}

		} catch (Exception e) {
			StatusCodeAPI2 = 404;
		}
		try {
			String Response = RestTemplate.getForObject(prop.API3_url, String.class);

			StatusCodeAPI3 = 200;
		} catch (Exception e) {
			StatusCodeAPI3 = 404;

		}
		
		//calling Get Limit rest api 
		try {
			
			statusCodeGetLimitRestApi=consumer.consumeRestGetLimit().getStatusCodeValue();
			
		}catch (Throwable e) {
			e.printStackTrace();
			statusCodeGetLimitRestApi=404;
		}
		
		//calling Create Session rest api 
		try {
			
			
			statusCodeCreasteSessionRestApi=restCreateSessionConsumer.consumeRestCreateSession().getStatusCodeValue();
			
		}catch (Throwable e) {
			e.printStackTrace();
			statusCodeGetLimitRestApi=404;
		}
		
		timeCheck.timeCheck();
		timeCheckAPI2.timeCheckAPI2();
		timeCheckAPI3.timeCheckAPI3();

	}

}
