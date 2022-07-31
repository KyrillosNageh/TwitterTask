package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.UserLoginPage;

public class UserCanTweetWithLinkCombineWithPhoto extends TestBase{

	HomePage homeOpject;
	UserLoginPage loginOpject;
	String username = "01207684978";
	String password = "1234567890@";
	String textData = "https://twitter.com/";
	
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

	
	@Test (priority = 6)
	 public void userCanTweetWithLinkCombineWithPhoto()
	{
		
		homeOpject =new HomePage(driver);
		homeOpject.userClearTextTweet();
		homeOpject.userTextTweet(textData);
//		Helper.captureScreenshot(driver, "Twiter");
		homeOpject.uploadPhoto(System.getProperty("user.dir")+"/uploads/k.JPG");
		homeOpject.userClickTweetBtn();
		String excpectedMassage = homeOpject.checktweet.getText();
		String actualMassage= "Your Tweet was sent.";
		Assert.assertTrue(excpectedMassage.contains(actualMassage));
	}
}
