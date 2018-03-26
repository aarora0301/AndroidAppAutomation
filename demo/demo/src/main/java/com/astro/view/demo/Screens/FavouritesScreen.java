package com.astro.view.demo.Screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.astro.view.demo.Utils.Utility;

public class FavouritesScreen extends Utility{

	public FavouritesScreen(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private String appPackagename=getPropertyConfig("Config", "AppPackageName");
	private String showsIcon="//*[contains(@resource-id ,'"+appPackagename+":id/tv_tab_title')"
			+"and (@text='Shows')]";
	private String showTittle=":id/tv_fav_title";
	private String edit=":id/action_edit";
	private String removeImage=":id/img_remove";
	private String removeSlider=":id/btn_remove_fav";
	
	
	private By showLabel=By.xpath(showsIcon);
	private By serialTittle=By.id(appPackagename+showTittle);
	private By editLabel=By.id(appPackagename+edit);
	private By removeImg=By.id(appPackagename+removeImage);
	private By remove=By.id(appPackagename+removeSlider);
	
	
	public String readShowTittle(){
		click(showLabel);
		return readWebElementTeXt(serialTittle);
	}

	public void removeShow(){
		click(editLabel);
		click(removeImg);
		click(remove);
	}
}
