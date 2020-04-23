package com.Spring.ClientWS.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.Spring.ClientWS.Config.LoadingPropFile;

@Component
public class RestCreateSessionConsumer /* extends TimerTask */{
	
	public static String rescodeCreatesession;
	public static String upDownStatusCreatesession;
	
	@Autowired
	LoadingPropFile loadingPropFile;
	public ResponseEntity<String> consumeRestCreateSession()  {
		
		
		RestTemplate rest = new RestTemplate();
	    HttpHeaders headers = new HttpHeaders();
	    
	   // headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
	    HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		 //Calling Create Session service
	    ResponseEntity<String> response = rest.exchange(loadingPropFile.app1_service2_rest, HttpMethod.GET, entity, String.class );
	    System.out.println("Printing response");
	    System.out.println(response.getStatusCodeValue());
	    
	    rescodeCreatesession=""+response.getStatusCodeValue();
	    upDownStatusCreatesession="UP";
	    
	    System.out.println(response.getStatusCode());
	    System.out.println(response.getBody());    
	    return response;
		
	}



}
