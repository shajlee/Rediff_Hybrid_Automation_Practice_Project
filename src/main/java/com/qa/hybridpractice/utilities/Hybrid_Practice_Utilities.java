package com.qa.hybridpractice.utilities;

import java.util.Date;

public class Hybrid_Practice_Utilities {
	
	
	public static String GenerateEmailWithTimeStamp() {
		Date date = new Date();
		String emailTimeStamp = date.toString().replace("", "_").replace(":", "_");
		return "chowdhurygs" +emailTimeStamp+ "@rediff.com";
	}
	public static CharSequence GeneratePasswordWithTimeStamp() {
		Date date1 = new Date();
		String passwordTimeStamp = date1.toString().replace("", "_").replace(":", "_");
		return "Shajlee" +passwordTimeStamp+ "1@";
	}
	public static final int IMPLICIT_WAIT_TIME = 10;
	public static final int PAGELOAD_TIME = 10;
	public static final int SCRIPT_TIME_OUT = 100;
	
		
		
		
	}


