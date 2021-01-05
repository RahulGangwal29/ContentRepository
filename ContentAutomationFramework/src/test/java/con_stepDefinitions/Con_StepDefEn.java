package con_stepDefinitions;

import con_cucPico.Con_CucPicoTest;
import config.ActionKeywords;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Con_StepDefEn extends Con_CucPicoTest {

	private Con_CucPicoTest concucpicotest;

	public Con_StepDefEn(Con_CucPicoTest concucpicotest) {

		this.concucpicotest = concucpicotest;

	}

	@Given("^User launches the driver and naviagtes to the website$")
	public void user_launches_the_driver_and_naviagtes_to_the_website() throws Throwable {

		concucpicotest.getAction().openBrowser();
		concucpicotest.getAction().navigate();

	}

	@Then("^validate whether the content present is expected client content$")
	public void validate_whether_the_content_present_is_expected_client_content() throws Throwable {
		
		concucpicotest.getAction().closeBrowser();
		
	}

	@When("^user is on home page and fetches the content of the page$")
	public void user_is_on_home_page_and_fetches_the_content_of_the_page() throws Throwable {
		
		concucpicotest.getDriverScript().execute_TestCase();
		Thread.sleep(6000);

	}

	@When("^user navigates to the our firm page and fetches the content of the page$")
	public void user_navigates_to_the_our_firm_page_and_fetches_the_content_of_the_page() throws Throwable {

		concucpicotest.getAction().ourFirm();
		concucpicotest.getDriverScript().execute_TestCase();
		Thread.sleep(6000);
		
	}

	@When("^user navigates to the our projects page and fetches the content of the page$")
	public void user_navigates_to_the_our_projects_page_and_fetches_the_content_of_the_page() throws Throwable {

		concucpicotest.getAction().ourProjects();
		concucpicotest.getDriverScript().execute_TestCase();
		Thread.sleep(6000);
		
	}

	@When("^user navigates to the our services page and fetches the content of the page$")
	public void user_navigates_to_the_our_services_page_and_fetches_the_content_of_the_page() throws Throwable {

		concucpicotest.getAction().ourServices();
		concucpicotest.getDriverScript().execute_TestCase();
		Thread.sleep(6000);
		
	}

	@When("^user navigates to the insights page and fetches the content of the page$")
	public void user_navigates_to_the_insights_page_and_fetches_the_content_of_the_page() throws Throwable {

		concucpicotest.getAction().insights();
		concucpicotest.getDriverScript().execute_TestCase();
		Thread.sleep(6000);
		
	}

	@When("^user navigates to the contact us page and fetches the content of the page$")
	public void user_navigates_to_the_contact_us_page_and_fetches_the_content_of_the_page() throws Throwable {

		concucpicotest.getAction().contactUs();
		concucpicotest.getDriverScript().execute_TestCase();
		Thread.sleep(6000);
	
	}

}
