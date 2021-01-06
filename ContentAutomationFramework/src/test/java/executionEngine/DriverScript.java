package executionEngine;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import config.ActionKeywords;
import config.Constants;
import utility.ExcelUtils;

public class DriverScript extends ActionKeywords {

	ConfigReader configReader;

	public static Properties OR;
	public static ActionKeywords actionKeywords;
	public static String sActionKeyword;
	public static String sPageObject;

	public static int iHomePage;
	public static int iOurFirm;
	public static int iProjects;
	public static int iOurServices;
	public static int iInsights;
	public static int iContactUs;
	public static int iTestLastStep;
	public static String sWebPageName;
	public static Method method[];
	public static boolean bResult;
	public static String sData;
	public static String sData1;

	static int iTestcase = 1;

	public DriverScript() {

		actionKeywords = new ActionKeywords();
		method = actionKeywords.getClass().getMethods();

	}

	public void execute_TestCase() throws Exception {

		ExcelUtils.setExcelFile(Constants.Path_TestData);

		String Path_OR = Constants.Path_OR;
		FileInputStream fs = new FileInputStream(Path_OR);
		OR = new Properties(System.getProperties());
		OR.load(fs);

		System.out.println(driver.getCurrentUrl());
		String CurrentUrl = driver.getCurrentUrl();

		if (CurrentUrl.contains("our-firm"))

		{

			// int iTotalTestCases = ExcelUtils.getRowCount(Constants.Sheet_OurFirmPage);

			sWebPageName = ExcelUtils.getCellData(iTestcase, Constants.Col_WebPageName, Constants.Sheet_OurFirmPage);

			iOurFirm = ExcelUtils.getRowContains(sWebPageName, Constants.Col_WebPageName, Constants.Sheet_OurFirmPage);
			iTestLastStep = ExcelUtils.getTestStepsCount(Constants.Sheet_OurFirmPage, sWebPageName, iOurFirm);

			for (; iOurFirm < iTestLastStep; iOurFirm++) {
				sActionKeyword = ExcelUtils.getCellData(iOurFirm, Constants.Col_ActionKeyword,
						Constants.Sheet_OurFirmPage);
				sPageObject = ExcelUtils.getCellData(iOurFirm, Constants.Col_Component, Constants.Sheet_OurFirmPage);

				for (int i = 0; i < method.length; i++) {

					if (method[i].getName().equals(sActionKeyword)) {

						method[i].invoke(actionKeywords, sPageObject, sData);

						sData = ExcelUtils.getCellData(iOurFirm, Constants.Col_ExpectedContent,
								Constants.Sheet_OurFirmPage);
						System.out.println(sData);

						sData1 = ExcelUtils.getCellData(iOurFirm, Constants.Col_ActualContent,
								Constants.Sheet_OurFirmPage);
						System.out.println(sData1);

						if (sData.equals(sData1)) {
							ExcelUtils.setCellData(Constants.KEYWORD_MATCHED, iOurFirm, Constants.Col_ContentMatched,
									Constants.Sheet_OurFirmPage);
							break;
						} else {
							ExcelUtils.setCellData(Constants.KEYWORD_NOT_MATCHED, iOurFirm,
									Constants.Col_ContentMatched, Constants.Sheet_OurFirmPage);
							// ActionKeywords.closeBrowser();
							break;

						}
					}
				}

			}

		}

		else if (CurrentUrl.contains("projects"))

		{

			// int iTotalTestCases = ExcelUtils.getRowCount(Constants.Sheet_OurFirmPage);

			sWebPageName = ExcelUtils.getCellData(iTestcase, Constants.Col_WebPageName,
					Constants.Sheet_OurProjectsPage);

			iProjects = ExcelUtils.getRowContains(sWebPageName, Constants.Col_WebPageName,
					Constants.Sheet_OurProjectsPage);
			iTestLastStep = ExcelUtils.getTestStepsCount(Constants.Sheet_OurProjectsPage, sWebPageName, iProjects);

			for (; iProjects < iTestLastStep; iProjects++) {
				sActionKeyword = ExcelUtils.getCellData(iProjects, Constants.Col_ActionKeyword,
						Constants.Sheet_OurProjectsPage);
				sPageObject = ExcelUtils.getCellData(iProjects, Constants.Col_Component,
						Constants.Sheet_OurProjectsPage);

				for (int i = 0; i < method.length; i++) {

					if (method[i].getName().equals(sActionKeyword)) {

						method[i].invoke(actionKeywords, sPageObject, sData);

						sData = ExcelUtils.getCellData(iProjects, Constants.Col_ExpectedContent,
								Constants.Sheet_OurProjectsPage);
						System.out.println(sData);

						sData1 = ExcelUtils.getCellData(iProjects, Constants.Col_ActualContent,
								Constants.Sheet_OurProjectsPage);
						System.out.println(sData1);

						if (sData.equals(sData1)) {
							ExcelUtils.setCellData(Constants.KEYWORD_MATCHED, iProjects, Constants.Col_ContentMatched,
									Constants.Sheet_OurProjectsPage);
							break;
						} else {
							ExcelUtils.setCellData(Constants.KEYWORD_NOT_MATCHED, iProjects,
									Constants.Col_ContentMatched, Constants.Sheet_OurProjectsPage);
							// ActionKeywords.closeBrowser();
							break;

						}
					}
				}

			}
		} 
		
		else if (CurrentUrl.contains("our-services"))

		{

			// int iTotalTestCases = ExcelUtils.getRowCount(Constants.Sheet_OurFirmPage);

			sWebPageName = ExcelUtils.getCellData(iTestcase, Constants.Col_WebPageName,
					Constants.Sheet_OurServicesPage);

			iOurServices = ExcelUtils.getRowContains(sWebPageName, Constants.Col_WebPageName,
					Constants.Sheet_OurServicesPage);
			iTestLastStep = ExcelUtils.getTestStepsCount(Constants.Sheet_OurServicesPage, sWebPageName, iOurServices);

			for (; iOurServices < iTestLastStep; iOurServices++) {
				sActionKeyword = ExcelUtils.getCellData(iOurServices, Constants.Col_ActionKeyword,
						Constants.Sheet_OurServicesPage);
				sPageObject = ExcelUtils.getCellData(iOurServices, Constants.Col_Component,
						Constants.Sheet_OurServicesPage);

				for (int i = 0; i < method.length; i++) {

					if (method[i].getName().equals(sActionKeyword)) {

						method[i].invoke(actionKeywords, sPageObject, sData);

						sData = ExcelUtils.getCellData(iOurServices, Constants.Col_ExpectedContent,
								Constants.Sheet_OurServicesPage);
						System.out.println(sData);

						sData1 = ExcelUtils.getCellData(iOurServices, Constants.Col_ActualContent,
								Constants.Sheet_OurServicesPage);
						System.out.println(sData1);

						if (sData.equals(sData1)) {
							ExcelUtils.setCellData(Constants.KEYWORD_MATCHED, iOurServices,
									Constants.Col_ContentMatched, Constants.Sheet_OurServicesPage);
							break;
						} else {
							ExcelUtils.setCellData(Constants.KEYWORD_NOT_MATCHED, iOurServices,
									Constants.Col_ContentMatched, Constants.Sheet_OurServicesPage);
							// ActionKeywords.closeBrowser();
							break;

						}
					}
				}

			}

		} 
		
		else if (CurrentUrl.contains("insights"))

		{

			// int iTotalTestCases = ExcelUtils.getRowCount(Constants.Sheet_OurFirmPage);

			sWebPageName = ExcelUtils.getCellData(iTestcase, Constants.Col_WebPageName, Constants.Sheet_InsightsPage);

			iInsights = ExcelUtils.getRowContains(sWebPageName, Constants.Col_WebPageName,
					Constants.Sheet_InsightsPage);
			iTestLastStep = ExcelUtils.getTestStepsCount(Constants.Sheet_InsightsPage, sWebPageName, iInsights);

			for (; iInsights < iTestLastStep; iInsights++) {
				sActionKeyword = ExcelUtils.getCellData(iInsights, Constants.Col_ActionKeyword,
						Constants.Sheet_InsightsPage);
				sPageObject = ExcelUtils.getCellData(iInsights, Constants.Col_Component, Constants.Sheet_InsightsPage);

				for (int i = 0; i < method.length; i++) {

					if (method[i].getName().equals(sActionKeyword)) {

						method[i].invoke(actionKeywords, sPageObject, sData);

						sData = ExcelUtils.getCellData(iInsights, Constants.Col_ExpectedContent,
								Constants.Sheet_InsightsPage);
						System.out.println(sData);

						sData1 = ExcelUtils.getCellData(iInsights, Constants.Col_ActualContent,
								Constants.Sheet_InsightsPage);
						System.out.println(sData1);

						if (sData.equals(sData1)) {
							ExcelUtils.setCellData(Constants.KEYWORD_MATCHED, iInsights, Constants.Col_ContentMatched,
									Constants.Sheet_InsightsPage);
							break;
						} else {
							ExcelUtils.setCellData(Constants.KEYWORD_NOT_MATCHED, iInsights,
									Constants.Col_ContentMatched, Constants.Sheet_InsightsPage);
							// ActionKeywords.closeBrowser();
							break;

						}
					}
				}

			}

		} 
		
		else if (CurrentUrl.contains("contact-us"))

		{

			// int iTotalTestCases = ExcelUtils.getRowCount(Constants.Sheet_OurFirmPage);

			sWebPageName = ExcelUtils.getCellData(iTestcase, Constants.Col_WebPageName, Constants.Sheet_ContactUsPage);

			iContactUs = ExcelUtils.getRowContains(sWebPageName, Constants.Col_WebPageName,
					Constants.Sheet_ContactUsPage);
			iTestLastStep = ExcelUtils.getTestStepsCount(Constants.Sheet_ContactUsPage, sWebPageName, iContactUs);

			for (; iContactUs < iTestLastStep; iContactUs++) {
				sActionKeyword = ExcelUtils.getCellData(iContactUs, Constants.Col_ActionKeyword,
						Constants.Sheet_ContactUsPage);
				sPageObject = ExcelUtils.getCellData(iContactUs, Constants.Col_Component,
						Constants.Sheet_ContactUsPage);

				for (int i = 0; i < method.length; i++) {

					if (method[i].getName().equals(sActionKeyword)) {

						method[i].invoke(actionKeywords, sPageObject, sData);

						sData = ExcelUtils.getCellData(iContactUs, Constants.Col_ExpectedContent,
								Constants.Sheet_ContactUsPage);
						System.out.println(sData);

						sData1 = ExcelUtils.getCellData(iContactUs, Constants.Col_ActualContent,
								Constants.Sheet_ContactUsPage);
						System.out.println(sData1);

						if (sData.equals(sData1)) {
							ExcelUtils.setCellData(Constants.KEYWORD_MATCHED, iContactUs, Constants.Col_ContentMatched,
									Constants.Sheet_ContactUsPage);
							break;
						} else {
							ExcelUtils.setCellData(Constants.KEYWORD_NOT_MATCHED, iContactUs,
									Constants.Col_ContentMatched, Constants.Sheet_ContactUsPage);
							// ActionKeywords.closeBrowser();
							break;

						}
					}
				}

			}

		} 
		
		else {

			// int iTotalTestCases = ExcelUtils.getRowCount(Constants.Sheet_HomePage);
			// for (int iTestcase = 1; iTestcase < iTotalTestCases; iTestcase++) {

			sWebPageName = ExcelUtils.getCellData(iTestcase, Constants.Col_WebPageName, Constants.Sheet_HomePage);

			iHomePage = ExcelUtils.getRowContains(sWebPageName, Constants.Col_WebPageName, Constants.Sheet_HomePage);
			iTestLastStep = ExcelUtils.getTestStepsCount(Constants.Sheet_HomePage, sWebPageName, iHomePage);

			for (; iHomePage < iTestLastStep; iHomePage++) {
				sActionKeyword = ExcelUtils.getCellData(iHomePage, Constants.Col_ActionKeyword,
						Constants.Sheet_HomePage);
				sPageObject = ExcelUtils.getCellData(iHomePage, Constants.Col_Component, Constants.Sheet_HomePage);

				for (int i = 0; i < method.length; i++) {

					if (method[i].getName().equals(sActionKeyword)) {

						method[i].invoke(actionKeywords, sPageObject, sData);

						sData = ExcelUtils.getCellData(iHomePage, Constants.Col_ExpectedContent,
								Constants.Sheet_HomePage);
						System.out.println(sData);

						sData1 = ExcelUtils.getCellData(iHomePage, Constants.Col_ActualContent,
								Constants.Sheet_HomePage);
						System.out.println(sData1);

						if (sData.equals(sData1)) {
							ExcelUtils.setCellData(Constants.KEYWORD_MATCHED, iHomePage, Constants.Col_ContentMatched,
									Constants.Sheet_HomePage);
							break;
						} else {
							ExcelUtils.setCellData(Constants.KEYWORD_NOT_MATCHED, iHomePage,
									Constants.Col_ContentMatched, Constants.Sheet_HomePage);
							// ActionKeywords.closeBrowser();
							break;

						}
					}
				}
			}

		}

	}

}
