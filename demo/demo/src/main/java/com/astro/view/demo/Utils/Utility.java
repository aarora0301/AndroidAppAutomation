package com.astro.view.demo.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Utility {
	
	protected WebDriver driver;
	public static Properties configfile;
	public static Properties locatorsfile;
	String OS = System.getProperty("os.name").toLowerCase();
	AndroidDriver<?> appium;
	String appPackageName;
	String appLocation;
	Dimension size;
	
	public Utility(WebDriver driver){
		this.driver = driver;
		OSValidator.setPropValues(OS);
		
	}
     
	public static Properties loadConfig(String filename){
		
		InputStream filereader=null;
		Properties properties = null;
			 
	   if(filename.trim().equalsIgnoreCase("config")){
			if(configfile == null){
				try {
				     configfile = new Properties();
				     filereader = new FileInputStream(System.getProperty("user.dir") + OSValidator.delimiter +"resources" + OSValidator.delimiter +"configuration.properties");
				     configfile.load(filereader);
				     properties = configfile;
				 	} catch (FileNotFoundException e) {
				 		// TODO Auto-generated catch block
				 		e.printStackTrace();
				 	} catch (IOException e) {
				 		// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			 else 
				 properties = configfile;
		    } 
		   return properties;
	}

	public static String getPropertyConfig(String fileName,String key){
		Properties prop = loadConfig(fileName);
		return prop.getProperty(key);
	}
	
	
  
  
   
	public WebElement getElementWhenVisible(By locator, long... waitSeconds){
	    
		long time;
		WebElement element = null;
		time = waitSeconds.length > 0 ? waitSeconds[0] : Integer.parseInt(getPropertyConfig("config","DEFAULT_TIMEOUT"));
		WebDriverWait wait = new WebDriverWait(driver, time);
			       
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element;
	
	}
	
	public List<WebElement> getElements(By locator){
		return driver.findElements(By.xpath(".//android.widget.TextView"));
	}
	
	
	public void click(By locator, long... waitSeconds){
		WebElement element = getElementWhenVisible(locator, waitSeconds);
		if(element != null){
			element.click();
		}
	}
	
	public boolean checkIfElementPresent(By locator, long... waitSeconds){
		long time;
		WebElement element = null;
		time= waitSeconds.length>0? waitSeconds[0] : Integer.parseInt(getPropertyConfig("config","DEFAULT_TIMEOUT"));
		try{
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				       .withTimeout(time, TimeUnit.SECONDS)
				       .pollingEvery(100, TimeUnit.MILLISECONDS);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			return true;
			}
		catch(Exception ex){
			return false;
			}
		}

	  
	  public void click(WebElement element){
			element.click();
		}
		
	  public boolean checkIfElementPresent(WebElement element, long... waitSeconds){
			long seconds = waitSeconds.length > 0 ? waitSeconds[0] : 5;
			try{
				driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
				Boolean isPresent = element.isDisplayed();
				return isPresent;
			  }
			catch(Exception e){
				//Do Nothing
			}return false;
		}
	  
	  public WebElement getElementWhenRefreshed(final By locater, final String attribute, final String text, long... waitSeconds){
			
			long seconds = waitSeconds.length > 0 ? waitSeconds[0] :Integer.parseInt(getPropertyConfig("config","DEFAULT_TIMEOUT"));
			WebElement element = null;
		        WebDriverWait wait  = new WebDriverWait(driver, seconds);
				Boolean val = wait.until(ExpectedConditions.refreshed(new ExpectedCondition<Boolean>(){
						public Boolean apply(WebDriver driver) {
							return driver.findElement(locater).getAttribute(attribute).trim().equalsIgnoreCase(text);
						}
						}));
					if(val)
					 element = driver.findElement(locater);
					return element;
					}		
	  
	 
	
	  public void InstallApp(){
		  appPackageName=getPropertyConfig("config","AppPackageName");
		  appLocation=System.getProperty("user.dir") + OSValidator.delimiter + "resources" + OSValidator.delimiter + "App" +OSValidator.delimiter+"viu.apk";
			
		    if(!appium.isAppInstalled(appLocation))
			  appium.installApp(appLocation);
			  }
	  
	  
	  public void swipingHorizontal()  {

		  size = driver.manage().window().getSize();
		  appium= (AndroidDriver)driver;
		  int startx = (int) (size.width * 0.90);
		  int endx = (int) (size.width * 0.01);
		  int starty = size.height / 2;
		  appium.swipe(startx, starty, endx, starty, 3000);
		  try {
			  Thread.sleep(1000);
		  } catch (InterruptedException e) {
			  // TODO Auto-generated catch block
			  e.printStackTrace();
		  }
	  }
	  
	  public void swipingVertical() {
		  size = driver.manage().window().getSize();
		  appium= (AndroidDriver)driver;
		  int starty = (int) (size.height * 0.80);
		  int endy = (int) (size.height * 0.10);
          int startx = size.width / 2;
          appium.swipe(startx, starty, startx, endy, 3000);
		  try {
			  Thread.sleep(2000);
		  } catch (InterruptedException e) {
			  // TODO Auto-generated catch block
			  e.printStackTrace();
		  }

	  }

	  public void sendKeys(By locator, String text, long...waitSeconds){
		  WebElement we=getElementWhenVisible(locator, waitSeconds);
		  we.sendKeys(text);
	  }
	  
	  public String  readWebElementTeXt(By locator, long...wait){
		  WebElement we=getElementWhenVisible(locator);
		  return we.getText();
		  
	  }
		
		
		
	
  }
