package fleamarket.test.entities;

import webdriver.BaseEntity;
import webdriver.utils.SMARTExcelUtils;

public class AccountEntity extends BaseEntity{
	private String userName;
	private String userMail;
	private String password;
	
	
	public AccountEntity(String filePath, String sheetName, int accountNum){
		SMARTExcelUtils excelUtils = new SMARTExcelUtils(filePath);
		this.userName = excelUtils.getCellValue(sheetName, accountNum, 0);
		this.userMail = excelUtils.getCellValue(sheetName, accountNum, 1);
		this.password = excelUtils.getCellValue(sheetName, accountNum, 2);
		
	}
	
	

	
	@Override
	protected String formatLogMsg(String message) {
		// TODO Auto-generated method stub
		return null;
	}





	public String getUserName() {
		return userName;
	}





	public void setUserName(String userName) {
		this.userName = userName;
	}





	public String getUserMail() {
		return userMail;
	}





	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}





	public String getPassword() {
		return password;
	}





	public void setPassword(String password) {
		this.password = password;
	}

}
