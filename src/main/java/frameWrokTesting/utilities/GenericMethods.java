package frameWrokTesting.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericMethods {
	WebDriver driver;
	
public GenericMethods(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	public void waitForElement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(locator));
		
	}
	
	public void scrollDownToEndByJavaScript() {
		JavascriptExecutor js =  (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}
	
	
	public void scrollDownToEndByKeyboard() {
		 Actions actions = new Actions(driver);
		    actions.sendKeys(Keys.END).perform();
	}
	
	public void moveToElement(WebElement element) {
		
		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();
		
	}
	
	public void goTo(String url) {
		driver.get(url);
	}
	
	

}
