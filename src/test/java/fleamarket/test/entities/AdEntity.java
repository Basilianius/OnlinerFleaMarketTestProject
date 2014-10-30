package fleamarket.test.entities;

import webdriver.BaseEntity;
import webdriver.utils.SMARTExcelUtils;

public class AdEntity extends BaseEntity{
	//todo enums
	private String category = "";
	private String topic = "";
	private String headline = "";
	private String place = "";
	private String body = "";
	private String subject = "";
	private String price = "";
	
	private String id;
	private String status;
	
	
	public AdEntity(String filePath, String sheetName, int adNum){
		SMARTExcelUtils excelUtils = new SMARTExcelUtils(filePath);
		
		this.setHeadline(excelUtils.getCellValue(sheetName, adNum, 2));
		this.setBody(excelUtils.getCellValue(sheetName, adNum, 4));
		this.setPrice(excelUtils.getCellValue(sheetName, adNum, 6));
		this.setSubject(excelUtils.getCellValue(sheetName, adNum, 5));
	}

	@Override
	protected String formatLogMsg(String message) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getHeadline() {
		return headline;
	}

	public void setHeadline(String headline) {
		this.headline = headline;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

}
