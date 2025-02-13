package FrameWrokTesting.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import FrameWrokTesting.base.BaseTest;
import frameWrokTesting.pageComponents.LoginPage;

public class LoginErrorest extends BaseTest {
	
	@Test
	public void errorValidations(){
		
		LoginPage login = new LoginPage(getDriver());
		login.goTo("https://rahulshettyacademy.com/client");
		String errMsg = login.errorLogin("erroremail@gmail.com", "12345");
		System.out.println(errMsg);
		Assert.assertEquals(errMsg, "Incorrect email or password.");
		
		
	}
	

}
