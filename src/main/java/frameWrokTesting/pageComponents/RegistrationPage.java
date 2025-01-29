package frameWrokTesting.pageComponents;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import frameWrokTesting.utilities.GenericMethods;

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
	WebElement ageConfirmation;
	
	@FindBy(id = "login")
	WebElement submitButton;
	
	
	@FindBy(xpath ="//h1[@class='headcolor']")
	WebElement confirmationMsg;
	

	public RegistrationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String formFillUp(String userFirstName, String userLastName,String userEmailId,String userMobileNumber,String userOccupation,String setPassword) {

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
		ageConfirmation.click();
		submitButton.click();
		try {
		    if (confirmationMsg.isDisplayed()) {
		        System.out.println("Confirmation message is displayed: " + confirmationMsg.getText());
		    }
		} catch (NoSuchElementException e) {
		    System.err.println("Error: Confirmation message not found. Please change the email.");
		}
		return confirmationMsg.getText();

	}

}
