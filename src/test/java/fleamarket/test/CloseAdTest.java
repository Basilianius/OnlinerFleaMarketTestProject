package fleamarket.test;


import java.util.HashMap;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import fleamarket.test.entities.AccountEntity;
import fleamarket.test.entities.AdEntity;
import fleamarket.test.forms.MainPage;
import fleamarket.test.forms.MyAdsPage;
import fleamarket.test.forms.ViewAdPage;
import fleamarket.test.keywords.CheckAdByAccountKW;
import fleamarket.test.keywords.LogOutLogInKW;
import webdriver.BaseTest;

public class CloseAdTest extends BaseTest {
	//Test parameters;
	private String baseUrl;
	private String accountFilePath;
	private String accountFileSheetName;
	private String adFilePath;
	private String adFileSheetName;	
	
	//Test values;
	private String adStatusExp;
	private AccountEntity testAccountMakerAd;
	private AdEntity newAd;

	@Test
	@Parameters({"baseUrl"
		, "accountFilePath"
		, "accountFileSheetName"
		, "adFilePath"
		, "adFileSheetName"
		, "adStatusExp"})
	public void readParams(String baseUrl
			, String accountFilePath
			, String accountFileSheetName
			, String adFilePath
			, String adFileSheetName
			, String adStatusExp
			) throws Throwable{
		this.baseUrl = baseUrl;
		this.accountFilePath = accountFilePath;
		this.accountFileSheetName = accountFileSheetName;
		this.adFilePath = adFilePath;
		this.adFileSheetName = adFileSheetName;
		this.adStatusExp = adStatusExp;
		
		this.testAccountMakerAd = new AccountEntity(this.accountFilePath, this.accountFileSheetName, 1);
		this.newAd = new AdEntity(this.adFilePath, this.adFileSheetName, 1);

		xTest();
	}

	@Override
	public void runTest() {
		LogStep();
		logger.info("Open MainPage".toUpperCase());
		browser.navigate(baseUrl);
		MainPage mainPage = new MainPage();

		LogStep();
		LogOutLogInKW logIn = new LogOutLogInKW();
	
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.clear();
		parameters.put("startPage", mainPage);
		parameters.put("account", testAccountMakerAd);
		
		logIn.runKeyword(parameters);
		
		LogStep();
		CheckAdByAccountKW checkAd = new CheckAdByAccountKW();

		parameters.clear();
		parameters.put("startPage", mainPage);
		parameters.put("ad", newAd);
		
		MyAdsPage myAdsPage = (MyAdsPage) checkAd.runKeyword(parameters);
		
		LogStep();
		logger.info("Open Ad".toUpperCase());
		myAdsPage.navigateToAd();
		
		LogStep();
		logger.info("Close Ad".toUpperCase());
		ViewAdPage viewAdPage = new ViewAdPage();
		
		String adIdBefore = viewAdPage.getAdId();
		viewAdPage.closeAd();
		
		
		String adIdAfter = viewAdPage.getAdId();
		String adStatus = viewAdPage.getAdStatus();
		
		LogStep();
		logger.info("Check Ad status".toUpperCase());
		assertEquals("Ad is not closed", this.adStatusExp, adStatus);
		assertEquals("Ad Id is not equals", adIdAfter, adIdBefore);
		logger.info("Check Ad status - SUCCESS".toUpperCase());
	}
}
