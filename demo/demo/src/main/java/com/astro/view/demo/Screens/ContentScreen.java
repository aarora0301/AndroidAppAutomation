package com.astro.view.demo.Screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.astro.view.demo.Utils.Utility;

public class ContentScreen extends Utility {

	public ContentScreen(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	private String appPackagename=getPropertyConfig("Config", "AppPackageName");
	private String arrow=":id/img_expand_arrow";
	private String serialText=":id/tv_show_long_desc";
	private String overFlowMenu=":id/fab_more";
	private String reminder=":id/img_reminder_action";
	private String favourites=":id/img_favourite_action";
	private String acceptReminder="android:id/button1";
	private String closeOverFlow=":id/img_close_action";
	private String showTittle=":id/tv_show_details_title";
	private String pressback="android.widget.ImageButton";
	
	 private By arrowImage=By.id(appPackagename+arrow);
	 private By serialDescription=By.id(appPackagename+serialText);
	 private By overFlow=By.id(appPackagename+overFlowMenu);
	 private By reminderIcon=By.id(appPackagename+reminder);
	 private By favouritesIcon=By.id(appPackagename+favourites);
	 private By dismisspopUp=By.id(acceptReminder);
	 private By closeOverFlowMenu=By.id(appPackagename+closeOverFlow);
	 private By serialTittle=By.id(appPackagename+showTittle);
	 private By pressBackButton=By.className(pressback);
	    
	    
	    public String readShowTittle(){
	    	return readWebElementTeXt(serialTittle);
	    }
	    
	    public String readShowDescription(){
	    	click(arrowImage);
	    	return readWebElementTeXt(serialDescription);
	    	 }
	    
	    
	    public void setReminder(){
	    	click(overFlow);
	    	click(reminderIcon);
	    	click(dismisspopUp);
	    	click(closeOverFlowMenu);
	    }
	    
	    public void markAsFavourite(){
	    	click(overFlow);
	    	click(favouritesIcon);
	    	click(closeOverFlowMenu);
	    	
	    }
	    
	    public void navigateToHome(){
	    	click(pressBackButton);
	    }
}
