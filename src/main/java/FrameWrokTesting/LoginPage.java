package frameWrokTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GenericMethods;

public class LoginPage extends GenericMethods{
	
	public LoginPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	WebDriver driver;
	
	@FindBy(id = "userEmail")
	WebElement userEmail;
	
	@FindBy(id = "userPassword")
	WebElement userPassword;
	
	@FindBy(id = "login")
	WebElement loginButton;
	
	
	public void login(String userName, String password) {
		
		userEmail.sendKeys(userName);
		userPassword.sendKeys(password);
		loginButton.click();
		
		
	}

}
