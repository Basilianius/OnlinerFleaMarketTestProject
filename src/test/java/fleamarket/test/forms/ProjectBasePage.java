package fleamarket.test.forms;

import org.openqa.selenium.By;

import webdriver.BaseForm;

public abstract class ProjectBasePage extends BaseForm{

	public ProjectBasePage(String formLocator, String formName) {
		super(By.xpath(formLocator), formName);
	}	
}
