package fleamarket.test.forms;

import org.openqa.selenium.By;

import fleamarket.test.entities.AdEntity;
import webdriver.elements.Button;
import webdriver.elements.ComboBox;
import webdriver.elements.TextBox;

public class NewAdPage extends ProjectBasePage {
	private static String formName = "NewAdPage";
	private static String formLocator = "//div[@class='b-ba-block']//h3[contains(text(), 'Как сделать объявление эффективным?')]";
	
	private Button btnCreateAd = new Button(By.xpath("//div[@class='b-ba-block']//button[@id='btnFleaMarketPostingSubmitEnabled']"), "CreateAd");
	
	private TextBox txbHeadline = new TextBox(By.xpath("//div[@class='i-view']/input[@name='subject']"), "Headline");
	private TextBox txbBody = new TextBox(By.xpath("//div[@class='resizable-textarea']//textarea[@name='message']"), "Body");
	private TextBox txbPrice = new TextBox(By.xpath("//div[@class='i-view']/input[@name='topic_price']"), "Price");
	
	private TextBox txbSubject = new TextBox(By.xpath("//div[@class='resizable-textarea']//textarea[@name='topic_desc']"), "Subject");
	
	private ComboBox cmbTopic = new ComboBox(By.xpath("//div[@class='i-view']/select[@class='selectForumId']"), "Topic");
		
	public NewAdPage(){
		super(formLocator, formName);
	}
	
	public void fillFields(AdEntity newAd){
		txbHeadline.type(newAd.getHeadline());
		txbBody.type(newAd.getBody());
		txbPrice.type(newAd.getPrice());
		
		txbSubject.setText(newAd.getSubject());
		cmbTopic.selectByIndex((int)Integer.valueOf(newAd.getTopic()));
	}
	
	public void createAd(AdEntity newAd){
		fillFields(newAd);
		btnCreateAd.click();
	}
	
}
