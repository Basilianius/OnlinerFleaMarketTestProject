package fleamarket.test.forms;

import org.openqa.selenium.By;

import fleamarket.test.entities.AccountEntity;
import webdriver.elements.Button;
import webdriver.elements.Link;
import webdriver.elements.TextBox;

public class MainPage extends ProjectBasePage{
	private static boolean signedStatus = false;
	
	private static String formName = String.format("MainPage signed is %s", signedStatus);
	private static String formLocator = "//ul[@class='b-top-navigation__additional-links']//a[contains(text(), 'Манифест')]";
	
	private Link lnkSignOut = new Link(By.xpath("//div[@class='b-top-profile__user-account']/a[@class='exit']"), "SignOut");
	
	private TextBox txbUserName = new TextBox(By.xpath("//div[@class='b-top-profile__log-in']//input[@name='username']"), "UserName");
	private TextBox txbPassword = new TextBox(By.xpath("//div[@class='b-top-profile__log-in']//input[@name='password']"), "Password");
	private TextBox txbHidePassword = new TextBox(By.xpath("//div[@class='b-top-profile__log-in']//input[@name='__nothing']"), "Password");
	private Button btnSignIn = new Button(By.xpath("//div[@class='b-top-profile__log-in']//button[@class='submit']"), "SignIn");
	
	private Link lnkUserName = new Link(By.xpath("//div[@class='b-top-profile__user-account']/p[@class='user-name']/a"), "UserName");
	
	public MainPage(){
		super(formLocator, formName);
	}
	
	public void signOut(){
		if (signedStatus && lnkSignOut.isPresent()){
			lnkSignOut.click();
		}
		signedStatus = false;
	}
	
	public void signInByUserName(String userName, String password){
		if (signedStatus){
			signOut();
		}
		txbUserName.type(userName);
		txbHidePassword.click();
		txbPassword.type(password);
		btnSignIn.click();
		
		signedStatus = true;
	}
	
	public void signInByUserMail(String userMail, String password){
		signInByUserName(userMail, password);
	}	
	
	public boolean assertSignedAccount(AccountEntity expectedAccount){
		
		String receivedUserName = lnkUserName.getText();
		String expectedUserName = expectedAccount.getUserName();
		
		assertEquals("Expected user is not matching with actual user", expectedUserName, receivedUserName);
		
		return true;
	}

}
