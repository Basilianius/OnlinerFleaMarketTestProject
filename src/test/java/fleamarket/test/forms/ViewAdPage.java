package fleamarket.test.forms;

import org.openqa.selenium.By;

import webdriver.elements.Label;

public class ViewAdPage extends ProjectBasePage {
	private static String formName = "NewAdPage";
	private static String formLocator = "//div[@class='bookmark-text']/a[contains(text(), 'Добавить в закладки')]";
	
	private Label lblAdId = new Label(By.xpath("//table[@class='basubj-info__tbl']//td[@class='bd numb']"), "AdId");
	private Label lblAdStatus = new Label(By.xpath("//table[@class='basubj-info__tbl']//td[@class='b-ba-subj-up']"), "AdStatus");
	
	public ViewAdPage(){
		super(formLocator, formName);
	}	
	
	public String getAdId(){
		String adId = lblAdId.getText().substring(2);
		return adId;
	}
	
	public String getAdStatus(){
		String adStatus = lblAdStatus.getText();
		return adStatus;
	}	
}
