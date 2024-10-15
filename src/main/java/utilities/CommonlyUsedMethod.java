package utilities;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import helper.Selenium_Actions;
import resources.BaseClass;

public class CommonlyUsedMethod {

	
	WebDriver driver = BaseClass.driver;
	Selenium_Actions selenium_Actions = new  Selenium_Actions(driver);
	public CommonlyUsedMethod(WebDriver driver) {
		this.driver = driver;
		
	}	
	
	public void getSeleniumWaitToClickAction(WebElement ele) {
		
		selenium_Actions.getWaitHelper().waitForElementwithFluentwait(driver, ele);
		selenium_Actions.getClickAndActionsHelper().moveToElement(ele);
		selenium_Actions.getClickAndActionsHelper().clickOnElement(ele);
		//return selenium_Actions;		
	}
	
	public void getSeleniumWaitToMoveToElementAction(WebElement ele) {

		selenium_Actions.getWaitHelper().waitForElementwithFluentwait(driver, ele);
		selenium_Actions.getClickAndActionsHelper().moveToElement(ele);
		//selenium_Actions.getClickAndActionsHelper().clickOnElement(ele);
		//return selenium_Actions;		
	}
	
	public void getSeleniumWaitToDoubleClickAction(WebElement ele) {

		selenium_Actions.getWaitHelper().waitForElementwithFluentwait(driver, ele);
		selenium_Actions.getClickAndActionsHelper().moveToElement(ele);
		selenium_Actions.getClickAndActionsHelper().doubleClick(ele);
		//return selenium_Actions;		
	}
	
      public void getSeleniumVisible(WebElement ele) {
		
		selenium_Actions.getWaitHelper().waitForElementwithFluentwait(driver, ele);
		selenium_Actions.getClickAndActionsHelper().moveToElement(ele);
		for(int i=0; i<=1000; i++) {
			
			try {
				
				Assert.assertEquals(ele.isDisplayed(), true);
				System.err.println("Visible");
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==1000) {
					System.err.println("Not Visible");
					Assert.fail(e.getMessage());
				}
			}
		}
		//return selenium_Actions;		
	}
      
      public void getSeleniumMoveToEle(WebElement ele) {
  		
  		selenium_Actions.getWaitHelper().waitForElementwithFluentwait(driver, ele);
  		selenium_Actions.getClickAndActionsHelper().moveToElement(ele);
  			
  	}
	
	public void getForLoopclickMethod(WebElement ele, int loopCount) {
		
		for(int i=0; i<=loopCount; i++) {
			
			try {
				ele.click();
				break;
			} catch (Exception e) {
				// TODO: handle exceptio
				if(i==loopCount) {
					
					Assert.fail(e.getMessage());
				}
			}
		}
	}
	
     public void getForLoopSendkeysMethod(WebElement ele, int loopCount, String value) {
		
		for(int i=0; i<=loopCount; i++) {
			
			try {
				selenium_Actions.getClickAndActionsHelper().doubleClick(ele);
				ele.sendKeys(Keys.CONTROL+"A",Keys.DELETE);
				ele.sendKeys( value, Keys.TAB);
				break;
			} catch (Exception e) {
				// TODO: handle exception
				if(i==loopCount) {

					Assert.fail(e.getMessage());
				}
			}
		}
	}
     
     public static String extractValueBeforeDecimal(String input) {
    	 input = input.replace("," , "");
    	 String[] parts = input.split("\\.");
    	 if(parts.length > 1 && parts[1].matches("0+")) {
    		 return parts[0];
    	 }
    	 else
    	 {
    		 return input;
    	 }
    }
     
}
