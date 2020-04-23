package com.rest.soap.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.rest.soap.properties.file.PropertyFile;
import com.rest.soap.properties.file.ServiceResponseCodePropertyLoader;

@Configuration
@ComponentScan(basePackages = { "com.rest.soap.properties.file" })
public class RestSoapConsumer {
	
	@Autowired
	PropertyFile propertyFile;
	@Autowired
	ServiceResponseCodePropertyLoader serviceResponseCodePropertyLoader;
	public void consumeRestGetLimit()
	{
//		List<HttpMessageConverter<?>> converters = 
//			      new ArrayList<HttpMessageConverter<?>>();
//			    converters.add(new MappingJackson2HttpMessageConverter());
		
		RestTemplate rest = new RestTemplate();
		//rest.setMessageConverters(converters);
		
	    HttpHeaders headers = new HttpHeaders();
	 //   headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<String> entity = new HttpEntity<String>(headers);
	    
//	    ResponseEntity<String> response = rest.exchange(propertyFile.app1_service1_rest, HttpMethod.GET, entity, String.class );
//	    System.out.println(response.getBody());
	    
	    //Calling GetLimit Service
	    ResponseEntity<RestResponse[]> response = rest.exchange(propertyFile.app1_service1_rest, HttpMethod.GET, entity, RestResponse[].class );
	  //  System.out.println(response.getBody());
	    RestResponse restResponse1=null;
	    for(RestResponse restResponse:response.getBody())
	    {
	    	restResponse1=restResponse;
	   // 	System.out.println(restResponse.id+"     "+restResponse.url);
	    }
	   // System.out.println();
	    if( (""+response.getStatusCodeValue()).equals(serviceResponseCodePropertyLoader.app1_service2_rest_response_code_status) 
	    		&& restResponse1.id.equals(serviceResponseCodePropertyLoader.app1_service2_rest_response_code_id) 
	    		&& restResponse1.url.equals(serviceResponseCodePropertyLoader.app1_service2_rest_response_code_url)) {
	    	System.out.println("Get Limit Up");
	    }
	    else {
	    	System.out.println("Get Limit Down");
	    
	    }

	    
	    //Calling Create Session Service
	    response=null;
	    serviceResponseCodePropertyLoader.app1_service2_rest_response_code_url=null;
//	   System.out.println("CS BODY"+rest.exchange(propertyFile.app1_service2_rest, HttpMethod.GET, entity, String.class ).getBody());  ;
	    response = rest.exchange(propertyFile.app1_service2_rest, HttpMethod.GET, entity, RestResponse[].class );
//	    System.out.println("Create sess"+response.getBody());
	    try {
	    	 restResponse1=null;
	 	    for(RestResponse restResponse:response.getBody())
	 	    {
	 	    	restResponse1=restResponse;
	 	    	//System.out.println(restResponse.sessionID+"     "+restResponse.url);
	 	    }
//	 	    System.out.println("url: "+serviceResponseCodePropertyLoader.app1_service1_rest_response_code_url);
//	 	    System.out.println("CS URL" + serviceResponseCodePropertyLoader.app1_service1_rest_response_code_url);
//	 	    System.out.println((""+response.getStatusCodeValue()).equals(serviceResponseCodePropertyLoader.app1_service1_rest_response_code_status)
//					+"       "+ restResponse1.sessionID.equals(serviceResponseCodePropertyLoader.app1_service1_rest_response_code_id)
//					+"       "+restResponse1.url.equals(  serviceResponseCodePropertyLoader.app1_service1_rest_response_code_url) );
//	 	    
	 	    
			if((""+response.getStatusCodeValue()).equals(serviceResponseCodePropertyLoader.app1_service1_rest_response_code_status)
					&& restResponse1.sessionID.equals(serviceResponseCodePropertyLoader.app1_service1_rest_response_code_id)
					&&restResponse1.url.equals(serviceResponseCodePropertyLoader.app1_service1_rest_response_code_url) ) {
				
				System.out.println(" Create Session Up");
			}
			else {
				System.out.println("Create Session Down");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    
	    
}
}