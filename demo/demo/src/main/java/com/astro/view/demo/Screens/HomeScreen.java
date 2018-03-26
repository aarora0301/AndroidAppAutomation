package com.astro.view.demo.Screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.astro.view.demo.Utils.Utility;

public class HomeScreen extends Utility{

	public HomeScreen(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	private String appPackagename=getPropertyConfig("Config", "AppPackageName");
	private String secondTab=".//android.widget.FrameLayout[@index='1']";
	private String mustWatch=":id/tv_tab_title";
	private String sideNavigation="//android.widget.ImageButton[@content-desc='Open navigation drawer']";
	private String menuLabel="//*[contains(@resource-id ,'"+appPackagename+":id/tv_menu_title')"
			+ "and (@text='Favourites')]";
    private By secondSeries=By.xpath(secondTab);
    private By mustWatchTab=By.id(appPackagename+mustWatch);
    private By navigationDrawer=By.xpath(sideNavigation);
    private By favouritesLabel=By.xpath(menuLabel);
    
    
    
     public void loadContent(){
    	getElementWhenVisible(mustWatchTab);
    	swipingVertical();
    	click(secondSeries);
    	}
     
     public void selectFavouritesLabel(){
    	 click(navigationDrawer);
         click(favouritesLabel);
     }
    }
