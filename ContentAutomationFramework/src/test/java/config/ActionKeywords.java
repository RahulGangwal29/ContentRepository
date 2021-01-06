package config;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import static executionEngine.DriverScript.OR;

import org.apache.commons.io.FileUtils;
import org.bridj.ann.Library;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverLogLevel;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import executionEngine.ConfigReader;
import executionEngine.DriverScript;
import utility.ExcelUtils;


public class ActionKeywords {

	public static WebDriver driver = null;
	static ConfigReader configReader = new ConfigReader();
	public static String ActualText;

	public void openBrowser() throws Exception {
		try {
			System.setProperty("webdriver.chrome.driver", Constants.Driver_Path_Chrome);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			int implicitWaitTime = (10);
			driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
		} catch (Exception e) {
			DriverScript.bResult = false;

		}

	}

	public void navigate() throws Exception {
		try {

			driver.get(configReader.getApplicationUrl());
			WebDriverWait wait = new WebDriverWait(driver, 20);

		} catch (Exception e) {
			DriverScript.bResult = false;

		}

	}

	public void ourFirm() throws Exception {
		try {

			driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/div[2]/div")).click();
			driver.findElement(By.linkText("Our firm")).click();
			WebDriverWait wait = new WebDriverWait(driver, 20);
			driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/a[2]/span/span[2]/svg[2]"))
					.click();

		} catch (Exception e) {
			DriverScript.bResult = false;

		}

	}

	public void ourProjects() throws Exception {
		try {

			driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/div[2]/div")).click();
			driver.findElement(By.linkText("Our projects")).click();
			WebDriverWait wait = new WebDriverWait(driver, 20);
			driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/a[2]/span/span[2]/svg[2]"))
					.click();

		} catch (Exception e) {
			DriverScript.bResult = false;

		}

	}

	public void ourServices() throws Exception {
		try {

			driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/div[2]/div")).click();
			driver.findElement(By.linkText("Our services")).click();
			WebDriverWait wait = new WebDriverWait(driver, 20);
			driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/a[2]/span/span[2]/svg[2]"))
					.click();

		} catch (Exception e) {
			DriverScript.bResult = false;

		}

	}

	public void insights() throws Exception {
		try {

			driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/div[2]/div")).click();
			driver.findElement(By.linkText("Insights")).click();
			WebDriverWait wait = new WebDriverWait(driver, 20);
			driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/a[2]/span/span[2]/svg[2]"))
					.click();

		} catch (Exception e) {
			DriverScript.bResult = false;

		}

	}

	public void contactUs() throws Exception {
		try {

			driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/div[2]/div")).click();
			driver.findElement(By.linkText("Contact us")).click();
			WebDriverWait wait = new WebDriverWait(driver, 20);
			driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/header/div[1]/div/a[2]/span/span[2]/svg[2]"))
					.click();

		} catch (Exception e) {
			DriverScript.bResult = false;

		}

	}

	public void fetchText(String object, String ActualText) throws InterruptedException {
		try {

			// System.out.println(driver.getCurrentUrl());
			String CurrentUrl = driver.getCurrentUrl();

			if (CurrentUrl.contains("our-firm"))

			{
				WebElement FT = driver.findElement(By.xpath(OR.getProperty(object)));

				Actions actions = new Actions(driver);
				actions.moveToElement(FT);
				actions.perform();
				Thread.sleep(3000);

				this.ActualText = FT.getText();

				ExcelUtils.setCellData(this.ActualText, DriverScript.iOurFirm, Constants.Col_ActualContent,
						Constants.Sheet_OurFirmPage);

			}

			else if (CurrentUrl.contains("projects"))

			{
				WebElement FT = driver.findElement(By.xpath(OR.getProperty(object)));

				Actions actions = new Actions(driver);
				actions.moveToElement(FT);
				actions.perform();
				Thread.sleep(3000);

				this.ActualText = FT.getText();

				ExcelUtils.setCellData(this.ActualText, DriverScript.iProjects, Constants.Col_ActualContent,
						Constants.Sheet_OurProjectsPage);
			}

			else if (CurrentUrl.contains("our-services"))

			{
				WebElement FT = driver.findElement(By.xpath(OR.getProperty(object)));

				Actions actions = new Actions(driver);
				actions.moveToElement(FT);
				actions.perform();
				Thread.sleep(3000);

				this.ActualText = FT.getText();

				ExcelUtils.setCellData(this.ActualText, DriverScript.iOurServices, Constants.Col_ActualContent,
						Constants.Sheet_OurServicesPage);
			}

			else if (CurrentUrl.contains("insights"))

			{
				WebElement FT = driver.findElement(By.xpath(OR.getProperty(object)));

				Actions actions = new Actions(driver);
				actions.moveToElement(FT);
				actions.perform();
				Thread.sleep(3000);

				this.ActualText = FT.getText();

				ExcelUtils.setCellData(this.ActualText, DriverScript.iInsights, Constants.Col_ActualContent,
						Constants.Sheet_InsightsPage);
			}

			else if (CurrentUrl.contains("contact-us"))

			{
				WebElement FT = driver.findElement(By.xpath(OR.getProperty(object)));

				Actions actions = new Actions(driver);
				actions.moveToElement(FT);
				actions.perform();
				Thread.sleep(3000);

				this.ActualText = FT.getText();

				ExcelUtils.setCellData(this.ActualText, DriverScript.iContactUs, Constants.Col_ActualContent,
						Constants.Sheet_ContactUsPage);
			}

			else {

				WebElement FT = driver.findElement(By.xpath(OR.getProperty(object)));

				Actions actions = new Actions(driver);
				actions.moveToElement(FT);
				actions.perform();
				Thread.sleep(3000);

				this.ActualText = FT.getText();

				ExcelUtils.setCellData(this.ActualText, DriverScript.iHomePage, Constants.Col_ActualContent,
						Constants.Sheet_HomePage);
			}

		} catch (Exception e) {
			DriverScript.bResult = false;

		}

	}

	public void pageUrl() {

		System.out.println(driver.getCurrentUrl());

	}

	public void closeBrowser() {
		try {
			// System.out.println(ActionKeywords.ActualText);
			driver.quit();

		} catch (AssertionError e) {
			DriverScript.bResult = false;
		}
	}

}