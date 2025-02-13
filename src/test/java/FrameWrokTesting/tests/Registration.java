package FrameWrokTesting.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import FrameWrokTesting.base.BaseTest;
import frameWrokTesting.pageComponents.CartPage;
import frameWrokTesting.pageComponents.LoginPage;
import frameWrokTesting.pageComponents.OrderConfirmationPage;
import frameWrokTesting.pageComponents.PaymentPage;
import frameWrokTesting.pageComponents.ProductCataloguePage;
import frameWrokTesting.pageComponents.RegistrationPage;

public class Registration extends BaseTest {

	String userFirstName = "User";
	String userLastName = "Test";
	String userEmailId = "usertest794@gmail.com";
	String userMobileNumber = "8542136582";
	String userOccupation = "Student";
	// String userGender = null;
	String setPassword = "User@123";

	// URL
	String url = "https://rahulshettyacademy.com/client";

	// Register

	@Test
	public void resgistartionTest() throws InterruptedException {
		RegistrationPage registrationPage = new RegistrationPage(getDriver());
		registrationPage.goTo(url);
		String accountCreationConfirmation = registrationPage.formFillUp(userFirstName, userLastName, userEmailId,
				userMobileNumber, userOccupation, setPassword);
		Assert.assertEquals(accountCreationConfirmation, "Account Created Successfully");
	}

}