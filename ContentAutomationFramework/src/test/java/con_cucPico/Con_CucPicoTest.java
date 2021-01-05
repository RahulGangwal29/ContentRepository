package con_cucPico;

import config.ActionKeywords;
import executionEngine.DriverScript;

public class Con_CucPicoTest {

	public ActionKeywords action;
	public DriverScript ds;

	public Con_CucPicoTest() {
		
		action = new ActionKeywords();
		ds = new DriverScript();
		 
		 }


    public ActionKeywords getAction() {
		return action;
	}

    public DriverScript getDriverScript() {
		return ds;
	}
		
}