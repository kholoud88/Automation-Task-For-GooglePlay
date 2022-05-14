package Tests;

import java.io.File;
import org.openqa.selenium.OutputType;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.google.common.io.Files;



public class TestBase {

	public static WebDriver driver;


	static Pages.AppstoreElements AppsElements;



	public static void OpenURL() 
	{

		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"\\src\\main\\java\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();



		options.addArguments("--allow-insecure-localhost");
		options.addArguments("start-maximized");
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability(ChromeOptions.CAPABILITY, options);
		caps.setCapability("acceptInsecureCerts", true);
		driver = new ChromeDriver(caps);

		//Open URL


		String BaseURL = "https://play.google.com/store";
		driver.get(BaseURL);

	}


	public static void Select_from_DDL(WebElement DDL, String name )
	{

		Select e = new Select(DDL);
		e.selectByVisibleText(name);
		
	}
	public static void Scroll_to_Element(WebElement e)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("arguments[0].scrollIntoView();", e);

	}

	public static void Click_on(WebElement e)
	{
		e.click();
	}

	public static void DoubleClick(WebElement e)
	{

		Actions actions = new Actions(driver);
		actions.doubleClick(e).perform();
	}

	public static void SendKeys(WebElement e,String text)
	{

		e.sendKeys(text);
	}

	public static void Clear(WebElement e)
	{
		e.clear();
	}

	public static void Submit(WebElement e)
	{
		e.submit();
	}

	public static void SelectFromMenu() 
	{

	}




	public static void Select_CheckBox(WebElement e)

	{
		if (e.isSelected()== false)
		{
			Click_on(e);

		}

		else 
		{
			return;
		}
	}



	public static void wait_until_Clickable(WebElement e)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(e));
		Click_on(e);
		//Clear(e);		
	}

	public static void wait_until_title_present(String e) {

		WebDriverWait wait = new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.titleContains(e));
	}

	public static void wait_until_element_present(WebElement e) {

		WebDriverWait wait = new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.visibilityOf(e));
	}


	public static void wait_10_seconds() {


		driver.manage().timeouts().implicitlyWait(300,TimeUnit.SECONDS) ;
	}

	public static void wait_until_URL(String URL)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.urlContains(URL));
	}

	public static void EndDriver()
	{

		//Quit the driver
		driver.quit();
	}




	@AfterMethod
	public void takeScreenShot(ITestResult result) throws IOException 
	{
		if (ITestResult.FAILURE == result.getStatus()) 
		{
			// create reference of TakesScreenShots
			TakesScreenshot ts = (TakesScreenshot)driver; 

			File source = ts.getScreenshotAs(OutputType.FILE);
			Files.copy(source, new File("./Screenshots/"+ result.getName()+".png"));
		}
	}











	public static boolean IS_Element_Exist(WebElement e) {

		try {

			if (e.isDisplayed()) {

				return true;

			} else {

				return false;
			}

		} catch (Exception ex) {

			ex.printStackTrace();
			return false;
		}
	}








}
