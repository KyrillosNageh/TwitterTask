package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.UserLoginPage;

public class UserCanNotTweetWithInvalidText extends TestBase {

	HomePage homeOpject;
	UserLoginPage loginOpject;
	String username = "01207684978";
	String password = "1234567890@";
	String textData = "01234567890123456789012345678901234567890123456789012345678901234567890123456789012345"
			+ "6789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789"
			+ "0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123"
			+ "456789a";
	
	@Test (priority = 1)
	public void userCanLoginSuccssfully()
	{
		homeOpject =new HomePage(driver);
		homeOpject.openLoginPage();
		loginOpject =new UserLoginPage(driver);
		loginOpject.userLogin(username, password);
		WebDriverWait wait =new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains("Home"));
		String excpectedUrl = driver.getCurrentUrl();
		String actualUrl= "https://twitter.com/home";
		Assert.assertEquals(excpectedUrl, actualUrl);
	}
	
	@Test (priority=7)
	public void userCanNotTweetWithMoreThan280Chars()
	{
		homeOpject =new HomePage(driver);
		homeOpject.userClearTextTweet();
		homeOpject.userTextTweet(textData);
		String excpectedMassage = homeOpject.exceededCharMassage.getText();
		String actualMassage= "You have exceeded the character limit by";
		System.out.println(homeOpject.exceededCharMassage.getText());
		Assert.assertTrue(excpectedMassage.contains(actualMassage));
	}
}
