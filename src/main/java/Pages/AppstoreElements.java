package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AppstoreElements extends PageBase{


	public AppstoreElements(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy (xpath = "//*[@id=\"fcxH9b\"]/div[1]/c-wiz[1]/ul/li[2]/a/span/span[2]")
	public WebElement APPSBtn;
	
	@FindBy (xpath = "//*[@id=\"action-dropdown-parent-Categories\"]")
	public WebElement CatDDL;
	
	@FindBy (xpath = "/html/body/div[1]/div[1]/c-wiz[2]/c-wiz/c-wiz/div/div/div/div[1]/div/div[2]/div/ul/li[1]/ul/li[30]/a")
	public WebElement Sports;

	
	
	
}



	