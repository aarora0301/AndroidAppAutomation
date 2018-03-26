package com.astro.view.demo.Utils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Driver {

	protected WebDriver driver;
	String OS = System.getProperty("os.name").toLowerCase();
	protected Utility util;


	public Driver(){
		OSValidator.setPropValues(OS);
		}


	@BeforeMethod
	public void initiateDriver(){
		File apk = new File(System.getProperty("user.dir")+ OSValidator.delimiter + "resources" + OSValidator.delimiter+"App", "astroView.apk"); 
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("app", apk.getAbsolutePath());
		capability.setCapability("autoLaunch", true);
		//capability.setCapability("fullReset",true);
		//capability.setCapability("noReset",false);
		capability.setCapability("platformName", "Android");
		capability.setCapability("platformVersion", "6.0.1");
		capability.setCapability("deviceName","Redmi");

		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capability);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void close(){
		if(driver != null)
			driver.quit();
	}


}
