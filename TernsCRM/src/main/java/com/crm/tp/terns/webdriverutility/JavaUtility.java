package com.crm.tp.terns.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int generateRandomNumber() {
		Random random=new Random();
		int ranno=random.nextInt(1000);
	return ranno;
	}
	
	public String getSystemDateInYYYYMMDD() {
		Date dateobj=new Date();
		
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String date=sim.format(dateobj);
	return date;
	}
	
	public String  getRequireDateInYYYYMMDDFromCalendar(int n) {
		
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, n);
		String date=sim.format(cal.getTime());
	return date;
	}
	
	
}
