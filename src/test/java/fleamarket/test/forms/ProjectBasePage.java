package fleamarket.test.forms;

import org.openqa.selenium.By;

import webdriver.BaseForm;
import webdriver.elements.Link;

public abstract class ProjectBasePage extends BaseForm{
	Link lnkLogo = new Link(By.xpath("//div[@class='onliner-top']//a"), "Logo");

	public ProjectBasePage(String formLocator, String formName) {
		super(By.xpath(formLocator), formName);
	}	
	
	final public void navigateToMainPage(){
		lnkLogo.click();
	}
}
