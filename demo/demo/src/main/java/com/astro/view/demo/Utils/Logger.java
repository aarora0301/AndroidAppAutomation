package com.astro.view.demo.Utils;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Logger {
	
	public static void info(Object str) {
		System.out.println(new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss").format(new GregorianCalendar().getTime()) + " | "
				+ Thread.currentThread().getStackTrace()[2].getFileName() + " | "
				+ Thread.currentThread().getStackTrace()[2].getMethodName() + " | " + str);
	}

}
