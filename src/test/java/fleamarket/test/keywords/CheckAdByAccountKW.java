package fleamarket.test.keywords;

import java.util.HashMap;

import webdriver.elements.Link;
import fleamarket.test.entities.AdEntity;
import fleamarket.test.forms.FleaMarketPage;
import fleamarket.test.forms.MainPage;
import fleamarket.test.forms.MyAdsPage;
import fleamarket.test.keywords.BaseKeyword.Status;

public class CheckAdByAccountKW extends BaseKeyword{
	private MainPage mainPage;
	private AdEntity ad;
	
	public CheckAdByAccountKW() {
		keywordName = this.getClass().getName().toString();
		keywordName = keywordName.substring(keywordName.lastIndexOf(".")+1);
	}
	
	@Override
	void beforeRun(HashMap<String, Object> parameters) {
		if (parameters.get("startPage") != null){
			this.mainPage = (MainPage) parameters.get("startPage");
		}
		if (parameters.get("ad") != null){
			this.ad = (AdEntity) parameters.get("ad");
		}		
		
	}
	@Override
	void run() {
		logger.info("Open FleaMarket".toUpperCase());		
		mainPage.navigateElementTopMenu("Барахолка");
	
		FleaMarketPage fleaMarketPage = new FleaMarketPage();

		logger.info("Navigate to MyAds".toUpperCase());
		fleaMarketPage.navigateToMyAds();
		
		MyAdsPage myAdsPage = new MyAdsPage();
		Link lnkAdHeadline = myAdsPage.findAdByHeadline(this.ad);
		
		if (lnkAdHeadline != null) {
			status = Status.SUCCESSED.toString();
		}
		
	}

}
