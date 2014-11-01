package fleamarket.test.keywords;


import java.util.HashMap;

import fleamarket.test.entities.AccountEntity;
import fleamarket.test.forms.MainPage;

public class LogOutLogInKW extends BaseKeyword{
	private MainPage mainPage;
	private AccountEntity account;

	public LogOutLogInKW() {
		keywordName = this.getClass().getName().toString();
		keywordName = keywordName.substring(keywordName.lastIndexOf(".")+1);
	}
	
	@Override
	void setParameters(HashMap<String, Object> parameters) {
		if (parameters.get("startPage") != null){
			this.mainPage = (MainPage) parameters.get("startPage");
		}
		if (parameters.get("account") != null){
			this.account = (AccountEntity) parameters.get("account");
		}
	}
	
	@Override
	void run() {
		logger.info("Sing out/in to account".toUpperCase());		
		mainPage.signInByUserName(account.getUserName(), account.getPassword());

		status = Status.SUCCESSED;
	}

}
