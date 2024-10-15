package helper;

import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dataProvider.DataBaseReader;

public class DataBaseHelper {
	WebDriver driver;
	private static final Logger logger = LogManager.getLogger(DataBaseHelper.class);

	public DataBaseHelper(WebDriver driver) {
		this.driver = driver;
	}

	DataBaseReader dataBaseReader = new DataBaseReader();
	WaitHelper waitHelper = new WaitHelper(driver);


	
	public void clickScreenUsingQuery(String optName,String appName) throws ClassNotFoundException, SQLException {
		List<String> listOfOptIDFromRET = dataBaseReader.getListOfOptIDFromRET(optName,appName);
		for (int i = listOfOptIDFromRET.size()-1; i >= 0; i--) {
			//System.out.println(i);
			String xpath = "//div[@id='"+listOfOptIDFromRET.get(i)+"']";
			String ulTagParent = "//div[@id='"+listOfOptIDFromRET.get(i)+"']/ul";
			String ulTagChild = "//div[@id='"+listOfOptIDFromRET.get(i)+"']/li/ul";
			for (int j = 0; j <200; j++) {
				try {
					if (i==listOfOptIDFromRET.size()-1) {
						if (driver.findElement(By.xpath(ulTagParent)).getAttribute("style").contains("none")) {
							driver.findElement(By.xpath(xpath)).click();
							break;
						}
					}
					else if (i==0) {
						driver.findElement(By.xpath(xpath)).click();
						break;
					}
					else {
						if (driver.findElement(By.xpath(ulTagChild)).getAttribute("style").contains("none")) {
							driver.findElement(By.xpath(xpath)).click();
							break;
						}
					}
				} catch (Exception e) {
					if (i==199) {
						Assert.fail(e.getMessage());
					}
				}
			}

		}
 
	}

	public void clickScreenUsingQuery2(String optName,String appName) throws ClassNotFoundException, SQLException {
		List<String> listOfOptIDFromRET = dataBaseReader.getListOfOptID(optName,appName);
		for (int i = listOfOptIDFromRET.size()-1; i >= 0; i--) {
			System.out.println(listOfOptIDFromRET.get(i));
			String xpath = "//div[@id='"+listOfOptIDFromRET.get(i)+"']";
			for (int j = 0; j <200; j++) {
				try {
					driver.findElement(By.xpath(xpath)).click();
					break;
				} catch (Exception e) {
					if (i==199) {
						Assert.fail(e.getMessage());
					}
				}
				
			}
			
			
		}

	}

	public String getValueUsingQuery(String objectName) {
	    try {
	        List<String> result = dataBaseReader.fetchDataFromDatabase2(objectName);
	        if (!result.isEmpty()) {
	            // Assuming the first item in the list is in the format "Result: [7]"
	            String rawValue = result.get(0); // Get the first item from the result list
	            Matcher matcher = Pattern.compile("\\d+").matcher(rawValue);
	            if (matcher.find()) {
	                return matcher.group(); // Return the extracted integer as a string
	            }
	        }
	        return "0"; // Return a default value if no integer is found
	    } catch (ClassNotFoundException | SQLException e) {
	        return "Error: " + e.getMessage();
	    }
	}

	public int getProductClassUsingQuery(String objectName) {
	    try {
	        List<String> result = dataBaseReader.fetchDataFromDatabase2(objectName);
	        if (!result.isEmpty()) {
	            // Assuming the first item in the list is in the format "Result: [7]"
	            String rawValue = result.get(0); // Get the first item from the result list
	            Matcher matcher = Pattern.compile("\\d+").matcher(rawValue);
	            if (matcher.find()) {
	                // Convert the extracted integer string to int and return
	                return Integer.parseInt(matcher.group());
	            }
	        }
	        // Return a default value if no integer is found
	        return 0;
	    } catch (ClassNotFoundException | SQLException e) {
	        // Log the error and return a special value to indicate an error
	        System.err.println("Error occurred while fetching product class: " + e.getMessage());
	        return -1; // Use -1 or another sentinel value to indicate an error
	    }
	}

	
	public String getdealStatus(String Query, String userId, String serialNo) {
		try {
			String Extracted_Deal = dataBaseReader.getDealStatus(Query, userId, serialNo);
			return "Extracted Deals : " + Extracted_Deal;
		} catch (Exception e) {
			return "Error: " + e.getMessage();
		}
	}

	public String getdealStatus2(String serialNo) {
		try {
			String Extracted_Deal = dataBaseReader.getDealStatus2(serialNo);
			return Extracted_Deal;
		} catch (Exception e) {
			return "Error: " + e.getMessage();
		}
	}

	public void UserSetOff() {
		// Call executeQueries() method from another class
		DataBaseReader.executeQueries();
	}

	public void runQuery(String Query) {
		DataBaseReader.executeQuerie(Query);
	}

}
