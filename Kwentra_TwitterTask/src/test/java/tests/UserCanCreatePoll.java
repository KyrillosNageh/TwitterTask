package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.UserLoginPage;

public class UserCanCreatePoll extends TestBase {

	HomePage homeOpject;
	UserLoginPage loginOpject;
	String username = "01207684978";
	String password = "1234567890@";
	String textData = "Test23";
	String choice1 = "a";
	String choice2 = "b";

	
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
	
	@Test(priority = 5)
	public void userCanCreatePoll()
	{
		homeOpject =new HomePage(driver);
		homeOpject.userClearTextTweet();
		homeOpject.userTextTweet(textData);
		homeOpject.userClickCreatePollBtn();
		homeOpject.userWriteChoice1(choice1);
		homeOpject.userWriteChoice2(choice2);
		homeOpject.userClickTweetBtn();
		String excpectedMassage = homeOpject.checktweet.getText();
		String actualMassage= "Your Tweet was sent.";
		Assert.assertTrue(excpectedMassage.contains(actualMassage));
	}
}
