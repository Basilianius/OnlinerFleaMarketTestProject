package fleamarket.test.forms;

import org.openqa.selenium.By;

import fleamarket.test.entities.AccountEntity;
import webdriver.elements.Button;
import webdriver.elements.Link;
import webdriver.elements.TextBox;

public class MainPage extends ProjectBasePage{
	private static boolean signedStatus = false;
	
	private static String formName = "MainPage";
	private static String formLocator = "//ul[@class='b-top-navigation__additional-links']//a[contains(text(), 'Манифест')]";
	
	private Link lnkSignOut = new Link(By.xpath("//div[@class='b-top-profile__user-account']/a[@class='exit']"), "SignOut");
	
	//old login
	//private TextBox txbUserName = new TextBox(By.xpath("//div[@class='b-top-profile__log-in']//input[@name='username']"), "UserName");
	//private TextBox txbPassword = new TextBox(By.xpath("//div[@class='b-top-profile__log-in']//input[@name='password']"), "Password");
	//private TextBox txbHidePassword = new TextBox(By.xpath("//div[@class='b-top-profile__log-in']//input[@name='__nothing']"), "Password");
	//private Button btnSignIn = new Button(By.xpath("//div[@class='b-top-profile__log-in']//button[@class='submit']"), "SignIn");
	
	private TextBox txbUserName = new TextBox(By.xpath("//div[@class='auth-box__field']//input[@placeholder='Ник или e-mail']"), "UserName");

	private TextBox txbPassword = new TextBox(By.xpath("//div[@class='auth-box__field']//input[@placeholder='Пароль']"), "Password");
	
	private Button btnSignInOpen = new Button(By.xpath("//div[@id='userbar']//div[@class='auth-bar__item auth-bar__item--text']"), "SignInOpen");
	private Button btnSignIn = new Button(By.xpath("//div[@class='auth-box__field']//button[@class='auth-box__auth-submit auth__btn auth__btn--green']"), "SignIn");
	
	private Link lnkUserName = new Link(By.xpath("//div[@class='b-top-profile__user-account']/p[@class='user-name']/a"), "UserName");
	
	private Link lnkElementTopMenu;
	private String elementTopMenuLocator = "//li[@class='b-main-navigation__item']/a[contains(text(),'%s')]";
	
	public MainPage(){
		super(formLocator, formName);
	}
	
	public void navigateElementTopMenu(String elementName){
		elementTopMenuLocator = String.format(elementTopMenuLocator, elementName); 
		lnkElementTopMenu = new Link(By.xpath(elementTopMenuLocator), elementName);
		lnkElementTopMenu.click();
		 
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
		btnSignInOpen.click();
		
		txbUserName.type(userName);
		//old login
		//txbHidePassword.click();
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
