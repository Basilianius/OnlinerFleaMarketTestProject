package fleamarket.test.forms;

import org.openqa.selenium.By;

import webdriver.elements.Link;
import fleamarket.test.entities.AdEntity;

public class MyAdsPage extends ProjectBasePage {
	private static String formName = "MyAdsPage";
	private static String formLocator = "//div[@class='b-up-section-4 arrow-bottom-right']/a[contains(text(),'UP выбранных')]";
	
	private Link lnkAdHeadline;
	private String lnkAdHeadlineLocator = "//h2[@class='wraptxt']/a[contains(text(), '%s')]";	
	
	public MyAdsPage(){
		super(formLocator, formName);
	}	
	
	public Link findAdByHeadline(AdEntity ad){
		String headline = ad.getHeadline();
		
		lnkAdHeadlineLocator = String.format(lnkAdHeadlineLocator, headline);
		lnkAdHeadline = new Link(By.xpath(lnkAdHeadlineLocator), "AdHeadline");
		
		if (! lnkAdHeadline.isPresent()){
			lnkAdHeadline = null;
		}
		
		//lnkAdHeadline = null;
		
		return lnkAdHeadline;
	}
	
	public void navigateToAd(){
		if (lnkAdHeadline != null){
			lnkAdHeadline.click();
		}
	}
}
