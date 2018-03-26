package com.astro.view.demo.Utils;

public class OSValidator {
	
	public static String shellType;
	public static String delimiter;
	 
	public static void setPropValues(String OS) {
		if (isWindows(OS)){
			shellType = "cmd";
			delimiter = "\\";
		}
		else if (isMac(OS)){
			shellType = "/bin/bash";
			delimiter = "/";
		}
		else{
			shellType = "cmd";
			delimiter = "\\";
		}
	}
 
	public static boolean isWindows(String OS) {
		return (OS.indexOf("win") >= 0);
	}
 
	public static boolean isMac(String OS) {
		return (OS.indexOf("mac") >= 0);
	}
 
}
