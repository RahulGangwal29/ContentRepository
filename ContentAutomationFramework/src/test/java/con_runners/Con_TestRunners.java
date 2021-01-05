package con_runners;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import cucumber.api.CucumberOptions;



@CucumberOptions(features = "/Users/rahgangw/git/Content-repository/ContentAutomationFramework/src/test/resources/testResources/KPS_En.feature", 
		glue = {"con_stepDefinitions"},
	//	plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
		monochrome = true)
	//	tags = {"@EmploymentDetailsSalariedEmployeeAccount"})



public class Con_TestRunners {





}
