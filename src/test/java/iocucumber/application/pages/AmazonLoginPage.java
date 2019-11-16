package iocucumber.application.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AmazonLoginPage {

	public AmazonLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
