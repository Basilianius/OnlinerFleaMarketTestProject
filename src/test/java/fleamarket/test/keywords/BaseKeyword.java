package fleamarket.test.keywords;

import java.util.HashMap;

import webdriver.BaseEntity;

public abstract class BaseKeyword extends BaseEntity{
	protected enum Status {FAILED, SUCCESSED}
	protected enum Action {START, END}
	
	protected String keywordName;
	protected Status status = Status.FAILED;
	
	protected Object returnParameters = null;
	
	public final Object runKeyword(HashMap<String, Object> parameters){
		display(Action.START.toString());
		setParameters(parameters);
		run();
		checkSuccess();
		
		display(Action.END.toString());
		display(status.toString());
		
		return returnParameters;
	}
	
	abstract void setParameters(HashMap<String, Object> parameters);
	
	abstract void run();
	
	void checkSuccess(){
		assertEquals("KeyWord is not executed", Status.SUCCESSED, status);
	}
	
	final void display(String action){
		logger.info("");
		logger.info(String.format("%s is %s", keywordName, action));
		//logger.info("");
	}
	
	public final String getName(){
		return keywordName;
	}	
	
	
	
	
	@Override
	protected String formatLogMsg(String message) {
		// TODO Auto-generated method stub
		return null;
	}
	
		

}
