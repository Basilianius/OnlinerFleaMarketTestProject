package fleamarket.test.forms;

import org.openqa.selenium.By;

import webdriver.elements.Label;
import webdriver.elements.Link;

public class ViewAdPage extends ProjectBasePage {
	private static String formName = "NewAdPage";
	private static String formLocator = "//div[@class='bookmark-text']/a[contains(text(), 'Добавить в закладки')]";
	
	private Label lblAdId = new Label(By.xpath("//table[@class='basubj-info__tbl']//td[@class='bd numb']"), "AdId");
	private Label lblAdStatus = new Label(By.xpath("//table[@class='basubj-info__tbl']//td[@class='b-ba-subj-up']"), "AdStatus");
	
	private Link lnkCloseAd = new Link(By.xpath("//div[@class='b-up-section-2 arrow-bottom']/a[@class='btn-style btn-send btn-close']"), "CloseAd");
	private Link lnkCloseAdOk = new Link(By.xpath("//div[@class='b-pop-up-i pop-up-2']//a[@class='btn-green confirm']/span"), "CloseAdOk");
			
	
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
	
	public void closeAd(){
		lnkCloseAd.click();
		lnkCloseAdOk.click();
		//lnkCloseAdOk.click();
		logger.info("");
	}
}
