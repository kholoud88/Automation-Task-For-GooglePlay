package Tests;
import static org.testng.Assert.assertTrue;

import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.AppstoreElements;

public class AppstoreTests extends TestBase{

	static   Pages.AppstoreElements El;


	//-----------------------------------------------------------------------------------------------------------------\\

	@Test(priority = 1,enabled = true)
	public static void Make_Sure_That_User_Can_Navigate_To_APPS_Screen_Correctly() throws InterruptedException
	{


		//Open URL 
		OpenURL();

		//Wait Until Opening The URL

		wait_until_title_present("Google Play");
		El = new AppstoreElements(driver);
		wait_until_Clickable(El.APPSBtn);		
		//GOTO APPS Button and Click on it 
		Click_on(El.APPSBtn);


		//Assert With URL
		String ExpectedURL = "https://play.google.com/store/apps";
		String ActualURL =driver.getCurrentUrl() ;
		Assert.assertEquals(ExpectedURL,ActualURL);
		EndDriver();
	}

	@Test(priority = 2,enabled = true)
	public static void Make_Sure_That_User_Can_Navigate_To_Education_Screen_Correctly() throws InterruptedException
	{




		//Open URL 
		OpenURL();

		//Wait Until Opening The URL

		wait_until_title_present("Google Play");
		El = new AppstoreElements(driver);
		wait_until_Clickable(El.APPSBtn);		
		//GOTO APPS Button and Click on it 
		Click_on(El.APPSBtn);
		Click_on(El.CatDDL);
		Scroll_to_Element(El.Sports);
		Click_on(El.Sports);
	

		//Assert With URL
		String ExpectedURL = "https://play.google.com/store/apps/category/SPORTS";
		String ActualURL =driver.getCurrentUrl() ;
		Assert.assertEquals(ExpectedURL,ActualURL);
		EndDriver();
	}

}