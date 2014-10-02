package fleamarket.test.keywords;

import java.util.HashMap;

import webdriver.BaseEntity;

public abstract class BaseKeyword extends BaseEntity{
	protected enum Status {FAILED, SUCCESSED}
	protected enum Action {START, END}
	
	protected String keywordName;
	protected String status = Status.FAILED.toString();
	
	public final void runKeyword(HashMap<String, Object> parameters){
		display(Action.START.toString());
		beforeRun(parameters);
		run();
		afterRun();
		
		display(Action.END.toString());
		display(status);
	}
	
	abstract void beforeRun(HashMap<String, Object> parameters);
	abstract void run();
	abstract void afterRun();
	
	final void display(String action){
		logger.info("");
		logger.info(String.format("%s is %s", keywordName, action));
		logger.info("");
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
