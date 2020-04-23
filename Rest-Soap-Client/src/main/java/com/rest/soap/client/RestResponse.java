package com.rest.soap.client;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RestResponse implements Serializable
{
	
	//String statusCodeValue;
	@JsonProperty("url")
	String url;
	@JsonProperty("id")
	String id;
	@JsonProperty("sessionID")
	String sessionID;
}
