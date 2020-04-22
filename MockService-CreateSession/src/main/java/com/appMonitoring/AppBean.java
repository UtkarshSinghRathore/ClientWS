package com.appMonitoring;

public class AppBean 
{
	int sessionID;
	String url;
	public int getSessionID() {
		return sessionID;
	}
	public void setSessionID(int sessionID) {
		this.sessionID = sessionID;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "AppBean [sessionID=" + sessionID + ", url=" + url + "]";
	}
	
	

}
