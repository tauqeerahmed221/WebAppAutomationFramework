package helper;

import java.text.NumberFormat;
import java.util.Locale;

import org.openqa.selenium.WebDriver;

import resources.BaseClass;

public class CurrnecyConvHelper {
	WebDriver driver = BaseClass.driver;
	
	public CurrnecyConvHelper(WebDriver driver) {
		this.driver = driver;
		
	}	
	

	 public static String convertToCurrency(String amountStr) {
	        try {
	            // Convert the string amount to an integer
	            int amountInt = Integer.parseInt(amountStr);
	            
	            // Get the currency format based on the default locale
	            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.getDefault());
	            
	            // Format the integer amount into currency
	            String formattedAmount = currencyFormat.format(amountInt);
	            
	            // Remove the dollar symbol from the formatted amount
	            formattedAmount = formattedAmount.replace(currencyFormat.getCurrency().getSymbol(), "");
	            
	            return formattedAmount.trim();  // Trim any leading/trailing whitespace
	        } catch (NumberFormatException e) {
	            return "Invalid amount format!";
	        }
	    }
	 
	 public  String convertCurrencyToString(String amountStr) {
	       
		 try {
	            // Convert the string amount to an integer
	        	
	             String convertedAmountInString= amountStr.replace(",","");
	             System.err.println(convertedAmountInString);
	            return convertedAmountInString.trim();  // Trim any leading/trailing whitespace
	        } catch (NumberFormatException e) {
	            return "Invalid amount format!";
	        }
	    }
}
