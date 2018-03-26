package com.astro.view.demo.Screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.astro.view.demo.Utils.Utility;

public class SplashScreen extends Utility {

	public SplashScreen(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	private String appPackagename=getPropertyConfig("Config", "AppPackageName");
	private String loader=":id/img_indicator_1";
	private By loaderView=By.id(appPackagename+loader);
	
	public void loadSplashScreen(){
	    getElementWhenVisible(loaderView);
		swipingHorizontal();
		swipingHorizontal();
		swipingHorizontal();
		swipingHorizontal();
		    
	}
}


