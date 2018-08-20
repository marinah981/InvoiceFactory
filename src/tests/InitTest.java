package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



public class InitTest {
	
	static WebDriver driver;
	  @BeforeClass
	  public static void SetUp() {
			 driver = new ChromeDriver();
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			 
	  }
	  @AfterClass
	  public void tearDown() {
		  driver.close();
	  }
}
