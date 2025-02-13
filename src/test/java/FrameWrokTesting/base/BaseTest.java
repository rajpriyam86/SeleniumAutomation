package FrameWrokTesting.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

	protected WebDriver driver;

	@BeforeMethod
	@Parameters("browser")
	public void browserSetup(@Optional("edge") String browser) throws IOException {
		//This section if we want to set the browser from property file
//		Properties prop = new Properties();
//		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"src\\main\\java\\frameWrokTesting\\globalComponents\\globalDataVariable.properties");
//		prop.load(fis);
//		String browserName = prop.getProperty(browser);

		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "F:/Automation Project/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}else if (browser.equalsIgnoreCase("InternetExplorer")) {
			driver = new InternetExplorerDriver();
		}
		else {
			System.out.println(browser + " is not a valid Browser please enter a valid Browser name");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		

	}

	// Getter method for driver
	public WebDriver getDriver() {
		return driver;
	}
	
	@AfterMethod
	public void closeWindow() {
		driver.close();
	}
	
	
	

}
