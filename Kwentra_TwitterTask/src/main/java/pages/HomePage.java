package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

	public String text="test";
	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath=("//a[@data-testid='loginButton']"))
	WebElement loginLink;


	@FindBy(xpath=("//a[@data-testid='AppTabBar_Home_Link']"))
	WebElement homeLink;


	@FindBy(xpath="//*[@data-testid='SideNav_NewTweet_Button']")
	WebElement tweetLink;

	@FindBy(xpath=("//*[@data-testid='tweetTextarea_0']"))
	WebElement tweetTextbox;

	@FindBy(xpath=("//*[@data-testid='tweetButtonInline']"))
	WebElement tweetBtn;

	@FindBy(css =("div[data-testid='toast']"))
	public WebElement checktweet;

	@FindBy(xpath=("//*[@data-testid='createPollButton']"))
	WebElement createPollBtn;

	@FindBy(xpath=("//*[@name='Choice1']"))
	 WebElement Choice1Txtarea;
	
	@FindBy(xpath=("//*[@name='Choice2']"))
	 WebElement Choice2Txtarea;
	
	@FindBy(xpath=("//*[@data-testid='fileInput']"))
	WebElement addPhotoBtn;
	
	@FindBy(xpath=("//*[@aria-live='assertive']"))
	public WebElement errorMassage;
	
	@FindBy(xpath=("//*[@aria-live='polite']"))
	public WebElement exceededCharMassage;
	
	public void openLoginPage()
	{
		loginLink.click();
	}
	
	public void openhomePage()
	{
		homeLink.click();
	}
	
	public void userTextTweet(String tweet)
	{
		setTextElementText(tweetTextbox,tweet);
	}
	
	public void userClearTextTweet()
	{
		clearText(tweetTextbox);
	}
	
	public void userClickTweetBtn()
	{
		clickButton(tweetBtn);	
	}
	
	public void openTweetPage()
	{
		clickButton(tweetLink);	
	}
	
	public void userClickCreatePollBtn()
	{
		clickButton(createPollBtn);	
	}
	
	public void userWriteChoice1(String choice)
	{
		setTextElementText(Choice1Txtarea,choice);
	}
	
	public void userWriteChoice2(String choice)
	{
		setTextElementText(Choice2Txtarea,choice);
	}
	
	public void uploadPhoto(String absolutePathOfPhoto)
	{	
		setPhoto(addPhotoBtn,absolutePathOfPhoto);
	}
	
}
