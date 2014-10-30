package fleamarket.test;

import java.util.HashMap;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import webdriver.BaseTest;
import fleamarket.test.entities.AccountEntity;
import fleamarket.test.entities.AdEntity;
import fleamarket.test.forms.FleaMarketPage;
import fleamarket.test.forms.MainPage;
import fleamarket.test.forms.ViewAdPage;
import fleamarket.test.keywords.CheckAdByAccountKW;
import fleamarket.test.keywords.LogOutLogInKW;

public class CreateAdTest extends BaseTest {
	//Test parameters;
	private String baseUrl;
	private String accountFilePath;
	private String accountFileSheetName;
	private String fleaMarketName;
	private String adFilePath;
	private String adFileSheetName;	
	
	//Test values;
	private AccountEntity testAccountMakerAd;
	private AdEntity newAd;

	@Test
	@Parameters({"baseUrl"
		, "accountFilePath"
		, "accountFileSheetName"
		, "fleaMarketName"
		, "adFilePath"
		, "adFileSheetName"})
	public void readParams(String baseUrl
			, String accountFilePath
			, String accountFileSheetName
			, String fleaMarketName
			, String adFilePath
			, String adFileSheetName
			) throws Throwable{
		this.baseUrl = baseUrl;
		this.accountFilePath = accountFilePath;
		this.accountFileSheetName = accountFileSheetName;
		this.fleaMarketName = fleaMarketName;
		this.adFilePath = adFilePath;
		this.adFileSheetName = adFileSheetName;
		
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
		logger.info("Navigate to FleaMarket".toUpperCase());
		mainPage.navigateElementTopMenu(this.fleaMarketName);
		
		FleaMarketPage fleaMarketPage = new FleaMarketPage();
		fleaMarketPage.createAdByAdEntity(newAd);
		fleaMarketPage.navigateToMainPage();
		
		LogStep();
		CheckAdByAccountKW checkAd = new CheckAdByAccountKW();

		parameters.clear();
		parameters.put("startPage", mainPage);
		parameters.put("ad", newAd);
		
		checkAd.runKeyword(parameters);
		
	}
}
