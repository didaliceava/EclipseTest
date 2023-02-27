package Com.TestNGFramwork.TestNGPractice;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;




public class TestNGAmazon {
	public static WebDriver driver;
	
	
	
	
	@BeforeTest// before test will only executed once 
	  public void beforeTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
		
		
	  }
	
	 
	 @Test(priority=1)
	  public void testTwo() throws InterruptedException {
		 driver.get("https://www.amazon.com/");
			driver.manage().window().maximize();
			Thread.sleep(3000);
		  System.out.println("This is  Test Two ");
		  Thread.sleep(3000);
	  }
	 
	 @Test(priority=2, dependsOnMethods= {"testTwo"}) // the dependsOnMethod , if testTwo fails, testOne will be skipped
	  public void testOne() throws InterruptedException {
		  System.out.println("This is  Test One");
		  Thread.sleep(3000);
	 }
	
	
 

  @AfterTest
  public void afterTest() throws InterruptedException {
	  System.out.println("This is After Test");
	  Thread.sleep(3000);
	  driver.close();
  }
  
  
  
  
  
  

}
