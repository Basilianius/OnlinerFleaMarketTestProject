package fleamarket.test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import webdriver.BaseTest;

public class RegisterAccountTest extends BaseTest {
	//Test parameters;
	
	//Test values;


	@Test
	@Parameters({})
	public void readParams(
			) throws Throwable{
		

		xTest();
	}

	@Override
	public void runTest() {
		LogStep();
		logger.info("STUB".toUpperCase());
		
	}

}
