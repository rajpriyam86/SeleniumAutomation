package FrameWrokTesting;

import java.sql.Array;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EndToEndTesting {

	public static void main(String[] args) throws InterruptedException {
		
		String userFirstName = "User";
		String userLastName = "Test";
		String userEmailId = "usertest84567@gmail.com";
		String userMobileNumber = "8542136582";
		String userOccupation = "Student";
//		String userGender = null;
		String setPassword = "User@123";
		
		String userName = "user.test54365@gmail.com";
		String password = "User@123";

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");

		// Register
		RegistrationPage registrationPage = new RegistrationPage(driver);
		registrationPage.formFillUp(userFirstName, userLastName, userEmailId, userMobileNumber, userOccupation, setPassword);
		

		// Login
		driver.get("https://rahulshettyacademy.com/client");
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(userName, password);
		

		// Selecting the product and adding to cart
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	

		// Getting the product list and adding to cart
		String productToBuy = "iPhone,qwerty";
		
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		String[] shoppingItems = productCatalogue.selectProduct(productToBuy);
		
		//going to cart
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		
		//Crosschecking the items are correct or not
		List<WebElement> cartItems = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
		for (WebElement cartItem : cartItems) {
		    boolean matchFound = false; // Flag to track if a match is found

		    for (String shoppingItem : shoppingItems) {
		        if (cartItem.getText().toLowerCase().contains(shoppingItem.toLowerCase())) {
		            matchFound = true; // Match found
		            break; // Exit inner loop
		        }
		    }

		    // Assert outside the inner loop to check if a match was found
		    Assert.assertTrue(matchFound, "Cart item does not match any shopping items: " + cartItem.getText());
		}
		
		//proceed to buy
		Thread.sleep(1000);
		JavascriptExecutor js =  (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[contains(@class, 'subtotal')]/ul/li[3]/button")));
		WebElement submitButton = driver.findElement(By.xpath("//div[contains(@class, 'subtotal')]/ul/li[3]/button"));
		
		submitButton.click();
		
		//Payment
		driver.findElement(By.xpath("//input[@class ='input txt'][1]")).sendKeys("856");
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("User");
		driver.findElement(By.xpath("//input[@placeholder ='Select Country']")).sendKeys("India");
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		WebElement selectCountry = driver.findElement(By.xpath("//button[@type='button'][2]"));
		action.moveToElement(selectCountry).click().build().perform();
		
		//placing order
		driver.findElement(By.xpath("//a[contains(@class, 'action__submit')]")).click();
		
		//confirmation
		Thread.sleep(2000);
		String confirmationmsg = driver.findElement(By.xpath("//h1[@class='hero-primary']")).getText();
		Assert.assertEquals(confirmationmsg, "THANKYOU FOR THE ORDER.");

		
		

	}

}
