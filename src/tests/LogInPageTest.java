package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogInPage;



public class LogInPageTest extends InitTest {
	LogInPage logIn;
	
  @Test(priority = 0 )
  public void signUp() {
	  logIn =  new LogInPage(driver);
	  driver.get("http://app.invoice-factory.source-code.rs");
	  Assert.assertTrue(logIn.isAt());
	  Assert.assertTrue(logIn.isSummaryPresent());
  }
 
  @Test(priority = 1)
  public void emptyMail() {
	  // empty e-mail field
	  logIn = new LogInPage(driver);
	  driver.get("http://app.invoice-factory.source-code.rs");
	  logIn.fillInputs(" ","qwe123 " );
//	  logIn.LgnBtn();
	  Assert.assertEquals(logIn.msgEmail(), "The email field is required.");
}
  @Test(priority = 2)
  public void emptyPass() {
	  // empty password field
	  logIn = new LogInPage(driver);
	  driver.get("http://app.invoice-factory.source-code.rs");
	  logIn.fillInputs("marinavujic81@gmail.com"," " );
//	  logIn.LgnBtn();
	  Assert.assertEquals(logIn.msgPass(), "The password field is required.");	  
}
  @Test(priority = 3)
  public void emptyMailAndPass() {
	  // empty e-mail and passwor field
	  logIn = new LogInPage(driver);
	  driver.get("http://app.invoice-factory.source-code.rs");
	  logIn.fillInputs(" "," " );
//	  logIn.LgnBtn();
	  Assert.assertEquals(logIn.msgEmail(), "The email field is required.");
	  Assert.assertEquals(logIn.msgPass(), "The password field is required.");
}
  @Test(priority = 4)
	public void invalidPass() {
	  //Login with correct email and invalid password
	  logIn = new LogInPage(driver);
		driver.get("http://app.invoice-factory.source-code.rs");
		logIn.fillInputs("marinavujic81@gmail.com", "qwe1234");
		logIn.lgnBtn();
		Assert.assertEquals(logIn.InvalidCredentials(), "Invalid credentials.");
  }
  @Test(priority = 5)
	public void invalidEmail() {
	  //Login with incorrect email and valid password
	  logIn = new LogInPage(driver);
		driver.get("http://app.invoice-factory.source-code.rs");
		logIn.fillInputs("marinavujic811@gmail.com", "qwe123");
		logIn.lgnBtn();
		Assert.assertEquals(logIn.InvalidCredentials(), "Invalid credentials.");
  }
  @Test(priority = 6)
 	public void passleast6greater20() {
 	  // Password length between 6 and 20
	  	logIn = new LogInPage(driver);
 		driver.get("http://app.invoice-factory.source-code.rs");
 		logIn.minSixGreaterTwenty();
  }
  @Test(priority = 7)
  	public void loginInvalidName() {
	  //email withoud domain name and invalid pass
	  	logIn = new LogInPage(driver);
		driver.get("http://app.invoice-factory.source-code.rs");
		logIn.fillInputs("marinavujic81", "password");
		logIn.lgnBtn();
		Assert.assertEquals(logIn.errorInvalidMail(), "The email field must be a valid email.");
  } 
 @Test(priority = 8)
	public void ShowPassword() {
	  // Show password
	  	logIn = new LogInPage(driver);
		driver.get("http://app.invoice-factory.source-code.rs");
		logIn.ShowPasswordBtn();
		logIn.showPassword.click();
		logIn.ShowPasswordBtn();
  }		
  @Test(priority = 9)
  public void allOk() {
	logIn =  new LogInPage(driver);
  	logIn.fillInputs("marinavujic81@gmail.com","qwe123");
	logIn.lgnBtn();
	
  } 
}