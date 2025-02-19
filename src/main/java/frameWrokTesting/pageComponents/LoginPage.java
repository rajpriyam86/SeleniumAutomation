package frameWrokTesting.pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import frameWrokTesting.utilities.GenericMethods;

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
	
	@FindBy(xpath="//div[@id='toast-container']/div")
	WebElement errorMsg;
	
	By errorElement = By.xpath("//div[@id='toast-container']/div");
	
	
	public void login(String userName, String password) {
		
		userEmail.sendKeys(userName);
		userPassword.sendKeys(password);
		loginButton.click();
		
		
	}
	public String errorLogin(String userName, String password) {
		
		userEmail.sendKeys(userName);
		userPassword.sendKeys(password);
		loginButton.click();
		waitForElement(errorElement);
		
		return errorMsg.getText();
		
		
		
	}
	

}
