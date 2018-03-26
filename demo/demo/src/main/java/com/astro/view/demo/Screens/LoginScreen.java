package com.astro.view.demo.Screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.astro.view.demo.Utils.Utility;

public class LoginScreen extends Utility{

	public LoginScreen(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	private String appPackagename=getPropertyConfig("Config", "AppPackageName");
	private String login=":id/btn_ftu_login";
	private String user="body_txtAstroID";
	private String passwd="body_txtPassword";
	private String loginbtn="body_btnLogin";
	private String agree=":id/btn_agree";
	
	private By loginButton=By.id(appPackagename+login);
	private By emailID=By.id(user);
	private By password=By.id(passwd);
	private By logInButton=By.id(loginbtn);
	private By agreeButton=By.id(appPackagename+agree);
	
	
	 public void login(){
	    	click(loginButton);
	    	sendKeys(emailID, getPropertyConfig("config","testid"));
	    	sendKeys(password, getPropertyConfig("config","password"));
	    	click(logInButton);
	    	click(agreeButton);
	    	}
}
