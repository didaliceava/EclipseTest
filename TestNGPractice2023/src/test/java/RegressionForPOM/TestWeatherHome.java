package RegressionForPOM;

import org.testng.annotations.Test;

import Com.PagesForPOM.WeatherHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;

public class TestWeatherHome extends WeatherHomePage{
	
	
	 @BeforeTest
	  public void beforeTest() throws InterruptedException, IOException {
		  
		  WebDriverManager.firefoxdriver().setup();
	      driver = new FirefoxDriver();
		  driver.get("https://weather.com/");
	      driver.manage().window().maximize();
	      ScreenShotTaking("testBrowserOpen Shot") ;
	      Thread.sleep(3000);
	      
		 
	  }
	
  @Test
  public void f() throws InterruptedException, IOException {
	  
	 WeatherHomePage obj= new WeatherHomePage(); // here when the object is cretaed the lements are being initialized because it is defined in the constructor
	  obj.locationSearchClick();
	  ScreenShotTaking("testOne Shot") ;
  }
  @Test
  public void b() throws InterruptedException, IOException {
	  
	 WeatherHomePage obj= new WeatherHomePage(); // here when the object is cretaed the lements are being initialized because it is defined in the constructor
	  obj.ibmTlogoVerification();
	  ScreenShotTaking("testTwo Shot") ;
  }
  
  
 

  @AfterTest
  public void afterTest() throws InterruptedException {
	  Thread.sleep(5000);
	  driver.close();
	 
  }
  
  
  

}
