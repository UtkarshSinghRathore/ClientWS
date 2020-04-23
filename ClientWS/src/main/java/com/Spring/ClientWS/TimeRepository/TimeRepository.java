package com.Spring.ClientWS.TimeRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class TimeRepository {
	
	private ArrayList<Date> UpTimeForApi1=new ArrayList<Date>();
	private ArrayList<Date> DownTimeForApi1=new ArrayList<Date>();
	private ArrayList<Date> UpTimeForApi2=new ArrayList<Date>();
	private ArrayList<Date> DownTimeForApi2=new ArrayList<Date>();
	private ArrayList<Date> UpTimeForApi3=new ArrayList<Date>();
	private ArrayList<Date> DownTimeForApi3=new ArrayList<Date>();
	
	public TimeRepository() {
		this.UpTimeForApi1.add(new Date());
		this.DownTimeForApi1.add(new Date());
		this.UpTimeForApi2.add(new Date());
		this.DownTimeForApi2.add(new Date());
		this.UpTimeForApi3.add(new Date());
		this.DownTimeForApi3.add(new Date());
	}
	

//	public TimeRepository(Date upTimeForApi1, Date downTimeForApi1, Date upTimeForApi2,
//			Date downTimeForApi2, Date upTimeForApi3, Date downTimeForApi3) {
//		this.UpTimeForApi1.add(upTimeForApi1);
//		this.DownTimeForApi1.add(downTimeForApi1);
//		this.UpTimeForApi2.add(upTimeForApi2);
//		this.DownTimeForApi2.add(downTimeForApi2);
//		this.UpTimeForApi3.add(upTimeForApi3);
//		this.DownTimeForApi3.add(downTimeForApi3);
//		
//	}

	public List<Date> getUpTimeForApi1() {
		return UpTimeForApi1;
	}

	public List<Date> getDownTimeForApi1() {
		return DownTimeForApi1;
	}

	public List<Date> getUpTimeForApi2() {
		return UpTimeForApi2;
	}

	public List<Date> getDownTimeForApi2() {
		return DownTimeForApi2;
	}

	public List<Date> getUpTimeForApi3() {
		return UpTimeForApi3;
	}

	public List<Date> getDownTimeForApi3() {
		return DownTimeForApi3;
	}

	public void setUpTimeForApi1(Date upTimeForApi1) {
		this.UpTimeForApi1.add(upTimeForApi1);
	}

	public void setDownTimeForApi1(Date downTimeForApi1) {
		this.DownTimeForApi1.add(downTimeForApi1);
	}

	public void setUpTimeForApi2(Date upTimeForApi2) {
		this.UpTimeForApi2.add(upTimeForApi2);
	}

	public void setDownTimeForApi2(Date downTimeForApi2) {
		this.DownTimeForApi2.add(downTimeForApi2); 
	}

	public void setUpTimeForApi3(Date upTimeForApi3) {
		this.UpTimeForApi3.add(upTimeForApi3);
	}

	public void setDownTimeForApi3(Date downTimeForApi3) {
		this.DownTimeForApi3.add(downTimeForApi3);
	}
	
	
	
	
	
	

}
