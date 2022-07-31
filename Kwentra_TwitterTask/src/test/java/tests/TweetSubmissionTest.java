package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.UserLoginPage;


public class TweetSubmissionTest extends TestBase {

	HomePage homeOpject;
	UserLoginPage loginOpject;

	
	@Test (priority = 1)
	public void userCanLoginSuccssfully()
	{
		homeOpject =new HomePage(driver);
		homeOpject.openLoginPage();
		loginOpject =new UserLoginPage(driver);
		loginOpject.userLogin("01207684978", "1234567890@");
		WebDriverWait wait =new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains("Home"));
		String excpectedUrl = driver.getCurrentUrl();
		String actualUrl= "https://twitter.com/home";
		Assert.assertEquals(excpectedUrl, actualUrl);
	}
	
	
	@Test (priority = 2)
	public void userCanTweetWithValidText()
	{
		
		homeOpject =new HomePage(driver);
		homeOpject.userClearTextTweet();
		homeOpject.userTextTweet("Test10");
		homeOpject.userClickTweetBtn();
		String excpectedMassage = homeOpject.checktweet.getText();
		String actualMassage= "Your Tweet was sent.";
		Assert.assertTrue(excpectedMassage.contains(actualMassage));
//		Whoops! You already said that.
	}
	
	
	@Test (priority = 3)
	public void userCanNotTweetTheSameTweetTwice()
	{
		
		homeOpject =new HomePage(driver);
		homeOpject.userClearTextTweet();
		homeOpject.userTextTweet("Test11");
		homeOpject.userClickTweetBtn();
		String excpectedMassage = homeOpject.checktweet.getText();
		String actualMassage= "Your Tweet was sent.";
		Assert.assertTrue(excpectedMassage.contains(actualMassage));
		homeOpject.userClearTextTweet();
		homeOpject.userTextTweet("Test11");
		homeOpject.userClickTweetBtn();
		System.out.println(homeOpject.errorMassage.getText());
		excpectedMassage = homeOpject.errorMassage
				.getText();
		actualMassage= "Whoops! You already said that.";
		Assert.assertTrue(excpectedMassage.contains(actualMassage));
//		Whoops! You already said that.
	}
	
	
	@Test(priority = 5)
	public void userCanTweetCreatePoll()
	{
		homeOpject =new HomePage(driver);
		homeOpject.userClearTextTweet();
		homeOpject.userTextTweet("Test12");
		homeOpject.userClickCreatePollBtn();
		homeOpject.userWriteChoice1("a");
		homeOpject.userWriteChoice2("b");
		homeOpject.userClickTweetBtn();
		String excpectedMassage = homeOpject.checktweet.getText();
		String actualMassage= "Your Tweet was sent.";
		Assert.assertTrue(excpectedMassage.contains(actualMassage));
	}
	

	@Test (priority = 4)
	 public void userCanTweetWithValidTextCombineWithPhoto()
	{
		homeOpject =new HomePage(driver);
		homeOpject.userClearTextTweet();
		homeOpject.userTextTweet("Test13");
		homeOpject.uploadPhoto(System.getProperty("user.dir")+"/uploads/k.JPG");
		homeOpject.userClickTweetBtn();
		String excpectedMassage = homeOpject.checktweet.getText();
		String actualMassage= "Your Tweet was sent.";
		Assert.assertTrue(excpectedMassage.contains(actualMassage));
	}
	
	@Test (priority = 6)
	 public void userCanTweetWithLinkCombineWithPhoto()
	{
		
		homeOpject =new HomePage(driver);
		homeOpject.userClearTextTweet();
		homeOpject.userTextTweet("https://twitter.com/");
		homeOpject.uploadPhoto(System.getProperty("user.dir")+"/uploads/k.JPG");
		homeOpject.userClickTweetBtn();
		String excpectedMassage = homeOpject.checktweet.getText();
		String actualMassage= "Your Tweet was sent.";
		Assert.assertTrue(excpectedMassage.contains(actualMassage));
	}
	
	
	@Test (priority=7)
	public void userCanNotTweetWithInvalidText()
	{
		homeOpject =new HomePage(driver);
		homeOpject.userClearTextTweet();
		homeOpject.userTextTweet("0123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789a");
//		Assert.assertTrue(homeOpject.tweetBtn.isEnabled());
		homeOpject.userClickTweetBtn();
//		String excpectedMassage = homeOpject.checktweet.getText();
//		String actualMassage= "Your Tweet was sent.";
//		Assert.assertTrue(excpectedMassage.contains(actualMassage));
	}
	

}
