package tests;


import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import pages.HomePage;
import pages.UserLoginPage;

public class UserCanLoginWithValidData extends TestBase{

	HomePage homeOpject;
	UserLoginPage loginOpject;
	String username = "01207684978";
	String password = "1234567890@";
	
	@Test
	public void userCanLoginSuccssfully()
	{
		homeOpject =new HomePage(driver);
		homeOpject.openLoginPage();
		loginOpject =new UserLoginPage(driver);
		loginOpject.userLogin(username, password);
		WebDriverWait wait =new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.titleContains("Home"));
		String excpectedUrl = driver.getCurrentUrl();
		String actualUrl= "https://twitter.com/home";
		Assert.assertEquals(excpectedUrl, actualUrl);

	}
}
