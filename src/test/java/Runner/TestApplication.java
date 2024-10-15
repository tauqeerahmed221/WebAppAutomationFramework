package Runner;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utilities.ExtentManager;
import utilities.ExtentTestManager;

@CucumberOptions(features = {//"src/test/java/feature_IIS" , 
		"src/test/java"},
                glue = "stepdefinitions",
                //monochrome=false, //to make steps in color
                plugin = { "pretty",
                           "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                           "rerun:ReRunScenarios/FailedReRun.txt"}
               //dryRun = true //to chek compilation errors                                      
               , tags=  //"@AT_IFC_019_01_DBQ or @AT_IFC_019_DBQ or @AT_IFC_020_01_DBQ or @AT_IFC_020_DBQ"
            		   //"@IslamicFinanceCalculator"
            		   "@AT_RA_01"
)
public class TestApplication extends AbstractTestNGCucumberTests {
	/*.
	 * @Override	
	 *
	 * @DataProvider(parallel = true) public Object[][] scenarios() { return
	 * super.scenarios(); }
	 */
	@Before
	public void beforeExecution() {
		System.out.println("*** Test Execution started ***");

	}
	

	@After
	public void afterExecution() {
		System.out.println("*** Test Execution Finished ***");
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

}