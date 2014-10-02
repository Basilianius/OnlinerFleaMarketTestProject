package fleamarket.test;

import java.util.HashMap;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import fleamarket.test.entities.AccountEntity;
import fleamarket.test.forms.MainPage;
import fleamarket.test.keywords.LogOutLogInKW;
import webdriver.BaseTest;

public class LogInTest extends BaseTest {
	//Test parameters;
	private String baseUrl;
	private String accountFilePath;
	private String accountFileSheetName;
	
	//Test values;
	private AccountEntity testAccountMakerAd;
	private AccountEntity testAccountViewerAd;


	@Test
	@Parameters({"baseUrl"
		, "accountFilePath"
		, "accountFileSheetName"})
	public void readParams(String baseUrl
			, String accountFilePath
			, String accountFileSheetName
			) throws Throwable{
		this.baseUrl = baseUrl;
		this.accountFilePath = accountFilePath;
		this.accountFileSheetName = accountFileSheetName;
		
		this.testAccountMakerAd = new AccountEntity(this.accountFilePath, this.accountFileSheetName, 0);
		this.testAccountMakerAd = new AccountEntity(this.accountFilePath, this.accountFileSheetName, 1);

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
		parameters.put("startPage", mainPage);
		parameters.put("account", testAccountMakerAd);
		
		logIn.runKeyword(parameters);
		
		LogStep();
		logger.info("Check signed account".toUpperCase());
		assertEquals("Check is not true", true, mainPage.assertSignedAccount(testAccountMakerAd));		
		
	}
}
