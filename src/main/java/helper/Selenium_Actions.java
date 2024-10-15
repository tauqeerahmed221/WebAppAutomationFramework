package helper;

import org.openqa.selenium.WebDriver;

public class Selenium_Actions {
   public  WebDriver driver;
   private AlertHelper alertHelper ;
   private BrowserHelper browserHelper;
   private ClicksAndActionsHelper clickAndActionsHelper;
   private GenericHelper genericHelper;
   private ScreenshotHelper screnshotHelper;
   private JavascriptHelper javascriptHelper;
   private VerificationHelper verficationHelper;
   private WaitHelper waitHelper;
   private DropDownHelper dropDownHelper;
   public Selenium_Actions(WebDriver driver2) {
	this.driver=driver2;
}
public AlertHelper getAlertHelper() {
	alertHelper = new AlertHelper(driver);
	return alertHelper;
}
public BrowserHelper getBrowserHelper() {
	browserHelper = new BrowserHelper(driver);
	return browserHelper;
}
public ClicksAndActionsHelper getClickAndActionsHelper() {
	clickAndActionsHelper = new ClicksAndActionsHelper(driver);
	return clickAndActionsHelper;
}
public GenericHelper getGenericHelper() {
	genericHelper = new GenericHelper();
	return genericHelper;
}
public ScreenshotHelper getScrenshotHelper() {
	screnshotHelper = new ScreenshotHelper(driver);
	return screnshotHelper;
}
public JavascriptHelper getJavascriptHelper() {
	javascriptHelper = new JavascriptHelper(driver);
	return javascriptHelper;
}
public VerificationHelper getVerficationHelper() {
	verficationHelper = new VerificationHelper();
	return verficationHelper;
}
public WaitHelper getWaitHelper() {
	waitHelper = new WaitHelper(driver);
	return waitHelper;
}
public DropDownHelper getDropDownHelper() {
	dropDownHelper = new DropDownHelper(driver);
	return dropDownHelper;
}
   
}
