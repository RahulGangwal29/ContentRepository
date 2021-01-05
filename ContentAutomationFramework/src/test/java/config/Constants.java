package config;

import java.io.File;
import executionEngine.ConfigReader;

public class Constants {


//	public static final String URL = configReader.getApplicationUrl(data);
	public static final String Path_TestData = "/Users/rahgangw/eclipse-workspace/ContentAutomationFramework/src/test/java/dataEngine/ContentValidationWorkBook.xlsx";
	public static final String Path_OR = "/Users/rahgangw/eclipse-workspace/ContentAutomationFramework/src/test/java/config/OR.txt";
	public static final String File_TestData = "ContentValidationWorkBook.xlsx";
	public static final String Driver_Path_Chrome = "/Users/rahgangw/Downloads/chromedriver.exe";
	
	
	// List of Data Sheet Column Numbers
	public static final int Col_WebPageName = 0;
	public static final int Col_ExpectedContent = 1;
	public static final int Col_ActualContent = 2;	
	public static final int Col_ActionKeyword = 4;
	public static final int Col_Component = 3;
	public static final int Col_Result = 2;
	public static final int Col_ContentMatched = 5;
	public static final String KEYWORD_NOT_MATCHED = "Not Matched";
	public static final String KEYWORD_MATCHED = "Matched";
//	public static final String ACTUAL_CONTENT = ActionKeywords.ActualText;

	// List of Data Engine Excel sheets
	public static final String Sheet_HomePage = "home page";
	public static final String Sheet_OurServicesPage = "our-services";
	public static final String Sheet_OurProjectsPage = "projects";
	public static final String Sheet_OurFirmPage = "our-firm";
	public static final String Sheet_InsightsPage = "insights";
	public static final String Sheet_ContactUsPage = "contact-us";
	// New entry in Constant variable
	public static final String Sheet_Summary = "summary";

}
