package iocucumber.base.pageobjectmanager;

import org.openqa.selenium.WebDriver;

import iocucumber.application.pages.AmazonLoginPage;

public class PageobjectManager {
	private WebDriver driver;

	private AmazonLoginPage amazonLoginPage;

	public PageobjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public AmazonLoginPage getAmazonLoginPageInstance() {
		return (amazonLoginPage == null) ? amazonLoginPage = new AmazonLoginPage(
				driver) : amazonLoginPage;
	}

}
