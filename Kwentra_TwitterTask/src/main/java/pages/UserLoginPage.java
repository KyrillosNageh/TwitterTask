package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserLoginPage extends PageBase {

	public UserLoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath=("//input[@autocomplete='username']"))
	WebElement usernameTxtBox;

	@FindBy(xpath = "//div[@class='css-901oao r-1awozwy r-jwli3a r-6koalj r-18u37iz r-16y2uox r-37j5jr r-a023e6 r-b88u0q r-1777fci r-rjixqe r-bcqeeo r-q4m81j r-qvutc0']")
	WebElement nextBtn;
	
	@FindBy(xpath=("//input[@autocomplete='current-password']"))
	WebElement passwordTxtBox;
	
	@FindBy(xpath=("//div[@class='css-901oao r-1awozwy r-6koalj r-18u37iz r-16y2uox r-37j5jr r-a023e6 r-b88u0q r-1777fci r-rjixqe r-bcqeeo r-q4m81j r-qvutc0']"))
	WebElement closeloginBtn;
	
	public void userLogin(String username,String password)
	{
		setTextElementText(usernameTxtBox,username);
		clickButton(nextBtn);
		setTextElementText(passwordTxtBox,password);
		clickButton(nextBtn);
		
	}
	

	
}
