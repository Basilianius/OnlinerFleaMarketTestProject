package fleamarket.test.forms;

import org.openqa.selenium.By;

import webdriver.elements.Link;

public class AccountMainPage  extends ProjectBasePage{
	private static String formName = "AccountMainPage";
	private static String formLocator = "//div[@class='b-top-profile__user-account']/a[@class='exit']";
	
	private Link lnkSignOut = new Link(By.xpath("//div[@class='b-top-profile__user-account']/a[@class='exit']"), "SignOut");
	
	public AccountMainPage(){
		super(formLocator, formName);
	}
	
	public void signOut(){
		lnkSignOut.click();
	}

}

