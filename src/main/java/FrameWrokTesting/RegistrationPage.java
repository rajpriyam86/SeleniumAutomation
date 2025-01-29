package FrameWrokTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage extends GenericMethods {


	WebDriver driver;
	
	// Registration button
	@FindBy(linkText = "Register")
	WebElement registerButton;
	// FirstName
	@FindBy(id = "firstName")
	WebElement firstName;
	// LastName
	@FindBy(id = "lastName")
	WebElement lastName;
	// userEmail
	@FindBy(id = "userEmail")
	WebElement userEmail;
	// userMobile
	@FindBy(id = "userMobile")
	WebElement userMobile;
	// Occupation
	@FindBy(xpath = "//select[@formcontrolname = 'occupation']")
	WebElement occupation;
	// Gender
	@FindBy(xpath = "//input[@value='Male']")
	WebElement gender;
	// userPassword
	@FindBy(id = "userPassword")
	WebElement userPassword;
	// confirmPassword
	@FindBy(id = "confirmPassword")
	WebElement confirmPassword;
	// Submit Button
	@FindBy(xpath = "//input[@type = 'checkbox']")
	WebElement submitButton;

	public RegistrationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void formFillUp(String userFirstName, String userLastName,String userEmailId,String userMobileNumber,String userOccupation,String setPassword) {

		registerButton.click();
		firstName.sendKeys(userFirstName);
		lastName.sendKeys(userLastName);
		userEmail.sendKeys(userEmailId);
		userMobile.sendKeys(userMobileNumber);
		Select select = new Select(occupation);
		select.selectByVisibleText(userOccupation);
		gender.click();
		userPassword.sendKeys(setPassword);
		confirmPassword.sendKeys(setPassword);
		submitButton.click();

	}

}
