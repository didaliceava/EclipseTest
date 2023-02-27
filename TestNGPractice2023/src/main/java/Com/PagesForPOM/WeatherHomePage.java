package Com.PagesForPOM;


import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class WeatherHomePage  {
	
	public static WebDriver driver;
	

	
	@FindBy(id="LocationSearch_input") WebElement locationSearch;
	
	@FindBy(xpath="(//*[text()='The Weather Channel'])[1]") WebElement IBMLogo;
	@FindBy(name="location") WebElement searchClick;
	
	public WeatherHomePage() {
		  PageFactory.initElements(driver, this);                       // by using this method in this constructor, when an object of this class is created , this method will be automatically executed
		
	}
	

	public void locationSearchClick() throws InterruptedException {
		locationSearch.sendKeys("San Antonio");
		searchClick.click();
		
	}
	
	public void ibmTlogoVerification() {
		String actualLogo=IBMLogo.getText();
		SoftAssert assertsoft=new SoftAssert();
		assertsoft.assertEquals(actualLogo, "The Weather Channel"); //Soft Assert
		assertsoft.assertAll();
		//Assert.assertEquals(actualLogo, "The Weather Channel"); //Hard Assert
		System.out.println("this is after assert test");
	}
	
	public  void ScreenShotTaking(String ShotName) throws IOException {
		  Date obj= new Date();
		  String myDate=obj.toString().replace(" ", "-").replace(":", "-");
		  
		    File MyScreenShots = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		    FileHandler.copy(MyScreenShots, new File("C:\\Users\\atdid\\eclipse-2021Workspace\\TestNGPractice2023\\SavedScreenShots\\"+myDate+".png"));
		}

}
