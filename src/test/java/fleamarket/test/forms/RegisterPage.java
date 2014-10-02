package fleamarket.test.forms;

public class RegisterPage extends ProjectBasePage{
	private static String formName = "RegisterPage";
	private static String formLocator = "//div[@class='minWidth']/h1[contains(text(), 'Регистрация')]";
	
	public RegisterPage(){
		super(formLocator, formName);
	}

}

