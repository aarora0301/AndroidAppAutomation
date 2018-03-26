package com.astro.view.demo;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;


import com.astro.view.demo.Screens.ContentScreen;
import com.astro.view.demo.Screens.FavouritesScreen;
import com.astro.view.demo.Screens.HomeScreen;
import com.astro.view.demo.Screens.LoginScreen;
import com.astro.view.demo.Screens.SplashScreen;
import com.astro.view.demo.Utils.Driver;

public class AppTest extends Driver{

	HomeScreen homeScreen;
	ContentScreen contentScreen;
	LoginScreen loginScreen;
	SplashScreen splashScreen;
	FavouritesScreen favouritesScreen;
	
	
   @BeforeMethod
   public void init(){
	   homeScreen=new HomeScreen(driver);
	   contentScreen=new ContentScreen(driver);
	   loginScreen=new LoginScreen(driver);
	   splashScreen=new SplashScreen(driver);
	   favouritesScreen=new FavouritesScreen(driver);
	}
   
   @Test(description="validate Synopsis has more than 50 Characters")
   public void validateSerialSynopsis(){
	 splashScreen.loadSplashScreen();
	 loginScreen.login();
	 homeScreen.loadContent();
	 String synopsis= contentScreen.readShowDescription();
	 Assert.assertTrue(synopsis.length()>=50,"Count characters in synopsis");
	   
   }
   
   @Test(description="Set Reminder and mark as Favourites")
   public void markReminder(){
	   splashScreen.loadSplashScreen();
	   loginScreen.login();
	   homeScreen.loadContent();
	   contentScreen.setReminder();
	   contentScreen.markAsFavourite();
	   }
  
   @Test(description="Validate show marked as Favourite is visible under Favourites Section")
	public void validateContent(){
	   splashScreen.loadSplashScreen();
	   loginScreen.login();
	   homeScreen.loadContent();
	   String contentTittle=contentScreen.readShowTittle();
	   contentScreen.setReminder();
	   contentScreen.markAsFavourite();
	   contentScreen.navigateToHome();
	   homeScreen.selectFavouritesLabel();
	   String expectedTittle=favouritesScreen.readShowTittle();
	   favouritesScreen.readShowTittle();
	   favouritesScreen.removeShow();
	   Assert.assertEquals(contentTittle,expectedTittle,"Test paased");
	   
	   
   }
}
