package com.appMonitoringService;

public class App {
int sessionID;
String url;
public int getId() {
	return sessionID;
}
public void setId(int id) {
	this.sessionID = id;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
@Override
public String toString() {
	return "App [id=" + sessionID + ", url=" + url + "]";
}


}
