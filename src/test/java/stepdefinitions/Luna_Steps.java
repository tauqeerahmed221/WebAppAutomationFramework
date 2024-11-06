package stepdefinitions;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObject.LumaTest_Obj;
import dataProvider.ExcelData;
import dataProvider.ExcelTest;
import helper.ScreenshotHelper;
import helper.Selenium_Actions;
import helper.WaitHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import junit.framework.Assert;

public class Luna_Steps {
	
	WebDriver driver = new ChromeDriver();
//tring path = System.getProperty("user.dir") + "\\Testdata\\DBQ_IIS_testdata.xlsx";
	//ExcelData testExecution = new ExcelData(path, "TestExecution", "TestCaseID");
	Map<String, String> testExecutionData;
//	ExcelTest excelTest = new ExcelTest(path, "TestExecution", "TestCaseID");
//	List<String> testCaseTagsFromExcel = excelTest.getTestCaseTagsfromExcel();
	//ChromeDriver driver1 = new ChromeDriver();
	
	LumaTest_Obj lumaTestObj = new LumaTest_Obj(driver);
	WaitHelper waitHelper = new WaitHelper(driver);
	Selenium_Actions seleniumActions = new Selenium_Actions(driver);

	ScreenshotHelper screenshotHelper = new ScreenshotHelper(driver);

	

	
	@Given("Navigate to Luna HomePage")
	public void Navigate_to_Luna_HomePage() {
		
		driver.get("https://magento.softwaretestingboard.com/");
	   
	}


	@And("user click on CreateAnAccount Link")
	public void user_click_on_CreateAnAccount_Link() {
		waitHelper.waitForElementwithFluentwait(driver, lumaTestObj.getCeateAnAccount_Link());
		seleniumActions.getClickAndActionsHelper().moveToElement(lumaTestObj.getCeateAnAccount_Link()); 

	    for (int i = 0; i < 500 ; i++) {
	    	try {
	    		seleniumActions.getClickAndActionsHelper().clickOnElement(lumaTestObj.getCeateAnAccount_Link());
	    		lumaTestObj.getCeateAnAccount_Link().click(); 
	    		break;
			} catch (Exception e) {
				Assert.fail(e.getMessage());
			}
		}
	}


	@And("user enter FirstaName under CreateAnAccount Link")
	public void user_enter_FirstaName_under_CreateAnAccount_Link() {
		waitHelper.waitForElementwithFluentwait(driver, lumaTestObj.getFirstName_Input());
		seleniumActions.getClickAndActionsHelper().moveToElement(lumaTestObj.getFirstName_Input());

	    for (int i = 0; i < 500 ; i++) {
	    	try {
	    		lumaTestObj.getFirstName_Input().sendKeys("Tauqe", Keys.TAB);
	    		break;
			} catch (Exception e) {
				Assert.fail(e.getMessage());
			}
		}
	}


	@And("user enter LastName under CreateAnAccount Link")
	public void user_enter_LastName_under_CreateAnAccount_Link() {
		waitHelper.waitForElementwithFluentwait(driver, lumaTestObj.getLastName_Input());
		seleniumActions.getClickAndActionsHelper().moveToElement(lumaTestObj.getLastName_Input());

	    for (int i = 0; i < 500 ; i++) {
	    	try {
	    		lumaTestObj.getLastName_Input().sendKeys("Ahmed", Keys.TAB);
	    		break;
			} catch (Exception e) {
				Assert.fail(e.getMessage());
			}
		}
	}


	@And("user enter Email under CreateAnAccount Link")
	public void user_enter_Email_under_CreateAnAccount_Link() {
		waitHelper.waitForElementwithFluentwait(driver, lumaTestObj.getEmail_Input());
		seleniumActions.getClickAndActionsHelper().moveToElement(lumaTestObj.getEmail_Input());

	    for (int i = 0; i < 500 ; i++) {
	    	try {
	    		lumaTestObj.getEmail_Input().sendKeys("abc233@gmail.com", Keys.TAB);
	    		break;
			} catch (Exception e) {
				Assert.fail(e.getMessage());
			}
		}
	}


	@And("user enter Password under CreateAnAccount Link")
	public void user_enter_Password_under_CreateAnAccount_Link() {
		waitHelper.waitForElementwithFluentwait(driver, lumaTestObj.getPassword_Input());
		seleniumActions.getClickAndActionsHelper().moveToElement(lumaTestObj.getPassword_Input());

	    for (int i = 0; i < 500 ; i++) {
	    	try {
	    		lumaTestObj.getPassword_Input().sendKeys("Augtech@#23", Keys.TAB);
	    		break;
			} catch (Exception e) {
				Assert.fail(e.getMessage());
			}
		}
	}


	@And("user enter ConfirmPassword under CreateAnAccount Link")
	public void user_enter_ConfirmPassword_under_CreateAnAccount_Link() {
		waitHelper.waitForElementwithFluentwait(driver, lumaTestObj.getConfirmPassword_Input());
		seleniumActions.getClickAndActionsHelper().moveToElement(lumaTestObj.getConfirmPassword_Input());

	    for (int i = 0; i < 500 ; i++) {
	    	try {
	    		lumaTestObj.getConfirmPassword_Input().sendKeys("Augtech@#23", Keys.TAB);
	    		break;
			} catch (Exception e) {
				Assert.fail(e.getMessage());
			}
		}
	}


	@And("user click on the CreateAnAccount button under CreateAnAccount Link")
	public void user_click_on_the_CreateAnAccount_button_under_CreateAnAccount_Link() {
		waitHelper.waitForElementwithFluentwait(driver, lumaTestObj.getCreateAnAccount_Button());
		seleniumActions.getClickAndActionsHelper().moveToElement(lumaTestObj.getCreateAnAccount_Button());

	    for (int i = 0; i < 500 ; i++) {
	    	try {
	    		seleniumActions.getClickAndActionsHelper().clickOnElement(lumaTestObj.getCreateAnAccount_Button());
	    		break;
			} catch (Exception e) {
				Assert.fail(e.getMessage());
			}
		}
	}


	@And("user Signout")
	public void user_Signout() {
		waitHelper.waitForElementwithFluentwait(driver, lumaTestObj.getActionSwitch_DrpDwn());
		seleniumActions.getClickAndActionsHelper().moveToElement(lumaTestObj.getActionSwitch_DrpDwn());

	    for (int i = 0; i < 500 ; i++) {
	    	try {
	    		seleniumActions.getClickAndActionsHelper().clickOnElement(lumaTestObj.getActionSwitch_DrpDwn());
	    		break;
			} catch (Exception e) {
				Assert.fail(e.getMessage());
			}
		}
	    
	    for (int i = 0; i < 500 ; i++) {
	    	try {
	    		seleniumActions.getClickAndActionsHelper().clickOnElement(lumaTestObj.getSignOut_Link());
	    		break;
			} catch (Exception e) {
				Assert.fail(e.getMessage());
			}
		}
	    
	}
	
	@And("user click on SignIn link")
	public void user_click_on_SignIn_link() {
		waitHelper.waitForElementwithFluentwait(driver, lumaTestObj.getSignIn_Link());
		seleniumActions.getClickAndActionsHelper().moveToElement(lumaTestObj.getSignIn_Link());

	    for (int i = 0; i < 500 ; i++) {
	    	try {
	    		seleniumActions.getClickAndActionsHelper().clickOnElement(lumaTestObj.getSignIn_Link());
	    		break;
			} catch (Exception e) {
				Assert.fail(e.getMessage());
			}
		}
	}


	@And("user enter Email under SignIn link")
	public void user_enter_Email_under_SignIn_link() {
		waitHelper.waitForElementwithFluentwait(driver, lumaTestObj.signInEmail_Input());
		seleniumActions.getClickAndActionsHelper().moveToElement(lumaTestObj.signInEmail_Input());

	    for (int i = 0; i < 500 ; i++) {
	    	try {
	    		lumaTestObj.signInEmail_Input().sendKeys("abc233@gmail.com", Keys.TAB);     
	    		break;
			} catch (Exception e) {
				Assert.fail(e.getMessage());
			}
		}
	}


	@And("user enter password under SignIn link")
	public void user_enter_password_under_SignIn_link() {
		waitHelper.waitForElementwithFluentwait(driver, lumaTestObj.signInPassword_Input());
		seleniumActions.getClickAndActionsHelper().moveToElement(lumaTestObj.signInPassword_Input());

	    for (int i = 0; i < 500 ; i++) {
	    	try {
	    		lumaTestObj.signInPassword_Input().sendKeys("Augtech@#23", Keys.TAB); 
	    		break;
			} catch (Exception e) {
				Assert.fail(e.getMessage());
			}
		}
	}
	
	@And("user click on the SignIn button under SignIn link")
	public void user_click_on_the_SignIn_button_under_SignIn_link() {
		waitHelper.waitForElementwithFluentwait(driver, lumaTestObj.signIn_SignIn_Btn());
		seleniumActions.getClickAndActionsHelper().moveToElement(lumaTestObj.signIn_SignIn_Btn());

	    for (int i = 0; i < 500 ; i++) {
	    	try {
	    		lumaTestObj.signIn_SignIn_Btn().click();
	    		break;
			} catch (Exception e) {
				Assert.fail(e.getMessage());
			}
		}
	}

}
