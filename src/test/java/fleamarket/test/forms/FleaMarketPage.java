package fleamarket.test.forms;

import org.openqa.selenium.By;

import fleamarket.test.entities.AdEntity;
import webdriver.elements.Link;

public class FleaMarketPage extends ProjectBasePage {
	private static String formName = "FleaMarketPage";
	private static String formLocator = "//ul[@class='onav__subnav fleamarket__1']//a[contains(text(), 'Мои объявления')]";
	
	private Link lnkCreateAd = new Link(By.xpath("//div[@class='b-fleamarket-button']/a[@class='b-btn-fleamarket__1']"), "CreateAd");
	private Link lnkMyAds = new Link(By.xpath("//ul[@class='onav__subnav fleamarket__1']//a[contains(text(), 'Мои объявления')]"), "MyAds");
		
	public FleaMarketPage(){
		super(formLocator, formName);
	}
	
	public void navigateToMyAds(){
		lnkMyAds.click();
	}
	
	public void createAdByAdEntity(AdEntity newAd){
		lnkCreateAd.click();
		
		NewAdPage newAdPage = new NewAdPage();
		newAdPage.createAd(newAd);
		
		ViewAdPage viewAdPage = new ViewAdPage();

		String adId = viewAdPage.getAdId();
		newAd.setId(adId);
		
		String adStatus = viewAdPage.getAdStatus();
		newAd.setStatus(adStatus);
	}
}
