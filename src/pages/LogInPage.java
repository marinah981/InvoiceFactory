package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogInPage extends PageObject{

	@FindBy(id="login-form-email")
	WebElement email;
	
	@FindBy(id="login-pass")
	WebElement pass;
	
	@FindBy(id="login-form-btn")
	WebElement lgnBtn;
	
	@FindBy(xpath = "//*[@id=\"home-page-user\"]")
	WebElement userName;
	
	@FindBy(className = "v-messages__message")
	List <WebElement> errorMailPassList;
	
	@FindBy (xpath="//*[@id=\"app\"]/div/main/div/div/div/div/form/div[1]/div[1]/div/div[2]/div/div/div")
	WebElement errorInvalidMail;
	
	@FindBy(xpath="//p[@class='body-2 my-0']")
	WebElement errorInvalidCredentials;

	@FindBy (xpath = "//div[@class='v-input__icon v-input__icon--append']/i")
	public
	WebElement showPassword;
	
	@FindBy (className ="v-messages__message")
	WebElement passSixChar;
	
	
	public LogInPage(WebDriver driver) {
		super(driver);
		}
	public boolean isAt() {
		// TODO Auto-generated method stub
		return true;
	}
	public boolean isSummaryPresent() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public void fillInputs(String Email, String Pass) {
		
		this.email.clear();
		this.pass.clear();
		this.email.sendKeys(Email);
		
		
		
		this.pass.sendKeys(Pass);
	}
	public void lgnBtn() {
		lgnBtn.click();
	}
	
	
	public String msgEmail() {
		wait.until(ExpectedConditions.visibilityOfAllElements(errorMailPassList));
		return errorMailPassList.get(0).getText();
	}
	public String msgPass() {
		wait.until(ExpectedConditions.visibilityOfAllElements(errorMailPassList));
		return errorMailPassList.get(1).getText();
	}
	public String errorInvalidMail() {
		return errorInvalidMail.getText();
}
	public String InvalidCredentials() {
		wait.until(ExpectedConditions.visibilityOf(errorInvalidCredentials));
		return errorInvalidCredentials.getText();
	}
	public String ShowPasswordBtn(){
		this.pass.clear();
		this.pass.sendKeys("sifra");
		if(showPassword.getText()== "visibility_off") {
			return "Password not visible";
		}else {
			return "Password is visible";
		}
	}
	public void minSixGreaterTwenty() {
		String[] password= {"@", "mama","3456","nea","qwert","marinamarinavujicvujic","lasdfghjloknbgotruioe","bddswf;zxcvbcfldjfdlfjffj"};
		for(String j : password) {
			this.pass.clear();
			this.pass.sendKeys(j);
			wait.until(ExpectedConditions.visibilityOf(pass));
			if(j.length()<6 || j.length()>20) {
				System.out.println(passSixChar.getText()+ ":" + j);
			} else {
				System.out.println( "Password valid lenght: " + j);
			}
		}
	}
	public String logedInInvoice() {
		wait.until(ExpectedConditions.visibilityOf(userName));
		return userName.getText();
	}	
}
	

